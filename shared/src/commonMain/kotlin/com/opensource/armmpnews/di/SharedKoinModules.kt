package com.opensource.armmpnews.di

import com.opensource.armmpnews.news.di.newsArticleModule

val sharedKoinModules = listOf(
    newsArticleModule,
    networkModule
)