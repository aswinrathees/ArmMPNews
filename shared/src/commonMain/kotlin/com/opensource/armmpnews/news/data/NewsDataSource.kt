package com.opensource.armmpnews.news.data

import opensource.armmpnews.db.ARMMPNewsDB

class NewsDataSource(private val db: ARMMPNewsDB) {

    fun getNewsArticles(): List<NewsRaw> = db.armMPNewsDBQueries.selectAllNews(::mapToNewsRaw).executeAsList()

    fun insertNewsArticles(newsArticles: List<NewsRaw>) {
        db.armMPNewsDBQueries.removeAllNews()
        db.armMPNewsDBQueries.transaction {
            newsArticles.forEach {
                insertNews(it)
            }
        }
    }

    fun clearNewsArtciles() {
        db.armMPNewsDBQueries.removeAllNews()
    }

    private fun insertNews(newsArticle: NewsRaw) {
        db.armMPNewsDBQueries.insertNews(
            title = newsArticle.title,
            desc = newsArticle.desc,
            date = newsArticle.date,
            imageUrl = newsArticle.imageUrl
        )
    }

    private fun mapToNewsRaw(
        title: String,
        desc: String,
        date: String,
        imageUrl: String
    ):NewsRaw = NewsRaw(
        title = title,
        desc = desc,
        date = date,
        imageUrl = imageUrl
    )
}