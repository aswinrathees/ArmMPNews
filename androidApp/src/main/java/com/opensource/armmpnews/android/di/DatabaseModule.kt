package com.opensource.armmpnews.android.di

import app.cash.sqldelight.db.SqlDriver
import com.opensource.armmpnews.db.DatabaseDriverFactory
import opensource.armmpnews.db.ARMMPNewsDB
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {

    single<SqlDriver> { DatabaseDriverFactory(androidContext()).createDriver() }

    single<ARMMPNewsDB> { ARMMPNewsDB(get()) }
}