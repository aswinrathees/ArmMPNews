package com.opensource.armmpnews.news.presentation

import com.opensource.armmpnews.news.application.NewsArticle

data class NewsState(
    val articles: List<NewsArticle> = listOf(),
    val loading: Boolean = false,
    val error: String? = null
)
