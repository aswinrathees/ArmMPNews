package com.opensource.armmpnews.di

import com.opensource.armmpnews.news.presentation.NewsViewModel
import com.opensource.armmpnews.sources.presentation.SourcesViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

fun initKoin() {

    val modules = sharedKoinModules + databaseModule

    startKoin {
        modules(modules)
    }
}

class NewsArticlesInjector: KoinComponent {

    val newsArticleViewModel: NewsViewModel by inject()
}

class SourcesInjector: KoinComponent {

    val sourcesViewModel: SourcesViewModel by inject()
}