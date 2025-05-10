package com.opensource.armmpnews.di

import com.opensource.armmpnews.news.di.newsArticleModule
import com.opensource.armmpnews.sources.di.sourceModule

val sharedKoinModules = listOf(
    newsArticleModule,
    sourceModule,
    networkModule
)