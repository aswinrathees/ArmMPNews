package com.opensource.armmpnews.android.di

import com.opensource.armmpnews.news.presentation.NewsViewModel
import com.opensource.armmpnews.sources.presentation.SourcesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {

    viewModel { NewsViewModel(get()) }
    viewModel { SourcesViewModel(get()) }
}