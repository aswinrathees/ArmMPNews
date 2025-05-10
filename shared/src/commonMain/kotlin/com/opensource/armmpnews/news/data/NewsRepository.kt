package com.opensource.armmpnews.news.data

class NewsRepository(
    private val dataSource: NewsDataSource,
    private val service: NewsService
) {

    suspend fun getNewsArticles(isForceFetch: Boolean): List<NewsRaw> {
        return when (isForceFetch) {
            true -> {
                dataSource.clearNewsArticles()
                fetchNewsArticles()
            }

            false -> {
                val newsDB = dataSource.getNewsArticles()
                if (newsDB.isEmpty()) {
                    fetchNewsArticles()
                } else {
                    newsDB
                }
            }
        }
    }

    private suspend fun fetchNewsArticles(): List<NewsRaw> {
        val fetchedArticles = service.fetchNewsArticles()
        dataSource.insertNewsArticles(fetchedArticles)
        return fetchedArticles
    }
}