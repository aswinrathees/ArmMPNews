package com.opensource.armmpnews.news.data

import opensource.armmpnews.db.ARMMPNewsDB

class NewsDataSource(private val db: ARMMPNewsDB) {

    fun getNewsArticles(): List<NewsRaw> = db.armMPNewsDBQueries.selectAllNews { title, desc, date, imageUrl ->
        NewsRaw(title, desc, date, imageUrl)
    }.executeAsList()

    fun insertNewsArticles(newsArticles: List<NewsRaw>) {
        db.armMPNewsDBQueries.removeAllNews()
        db.armMPNewsDBQueries.transaction {
            newsArticles.forEach {
                insertNews(it)
            }
        }
    }

    fun clearNewsArticles() {
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

    // Check
    private fun mapToNewsRaw(
        title: String,
        desc: String,
        date: String,
        imageUrl: String
    ): NewsRaw = NewsRaw(title, desc, date, imageUrl)
}