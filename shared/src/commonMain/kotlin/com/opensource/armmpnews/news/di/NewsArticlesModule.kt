package com.opensource.armmpnews.news.di

import com.opensource.armmpnews.news.application.NewsUseCase
import com.opensource.armmpnews.news.data.NewsDataSource
import com.opensource.armmpnews.news.data.NewsRepository
import com.opensource.armmpnews.news.data.NewsService
import com.opensource.armmpnews.news.presentation.NewsViewModel
import org.koin.dsl.module

val newsArticleModule = module {

    single<NewsService> { NewsService(get()) }
    single<NewsUseCase> { NewsUseCase(get()) }
    single<NewsViewModel> { NewsViewModel(get()) }
    //single<NewsDataSource> { NewsDataSource(get()) }
    single<NewsRepository> { NewsRepository(get(), get()) }
}