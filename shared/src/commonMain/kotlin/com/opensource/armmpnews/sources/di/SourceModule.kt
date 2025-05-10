package com.opensource.armmpnews.sources.di

import com.opensource.armmpnews.sources.application.SourcesUseCase
import com.opensource.armmpnews.sources.data.SourcesDataSource
import com.opensource.armmpnews.sources.data.SourcesRepository
import com.opensource.armmpnews.sources.data.SourcesService
import org.koin.dsl.module

val sourceModule = module {

    single { SourcesRepository(get(), get()) }
    single { SourcesService(get()) }
    single { SourcesUseCase(get()) }
    single { SourcesDataSource(get()) }
}