package com.opensource.armmpnews.news.application

import com.opensource.armmpnews.news.data.NewsRaw
import com.opensource.armmpnews.news.data.NewsRepository
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.todayIn
import kotlin.math.abs

class NewsUseCase(private val repository: NewsRepository) {

    suspend fun getArticles(isForceFetch: Boolean) : List<NewsArticle> {
        val newsArticles = repository.getNewsArticles(isForceFetch)
        return mapArticles(newsArticles)
    }

    private fun mapArticles(articlesRaw: List<NewsRaw>): List<NewsArticle> = articlesRaw.map { raw ->
        NewsArticle(
            raw.title,
            raw.desc ?: "Click to find out more",
            getDaysAgoString(raw.date),
            raw.imageUrl
                ?: "https://image.cnbcfm.com/api/v1/image/107326078-1698758530118-gettyimages-1765623456-wall26362_igj6ehhp.jpeg?v=1698758587&w=1920&h=1080"
        )
    }

    private fun getDaysAgoString(date: String): String {
        val today = Clock.System.todayIn(TimeZone.currentSystemDefault())
        val days = today.daysUntil(
            Instant.parse(date).toLocalDateTime(TimeZone.currentSystemDefault()).date
        )

        return when {
            abs(days) > 1 -> "${abs(days)} days ago"
            abs(days) == 1 -> "Yesterday"
            else -> "Today"
        }
    }
}