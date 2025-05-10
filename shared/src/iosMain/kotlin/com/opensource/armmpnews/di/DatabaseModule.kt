package com.opensource.armmpnews.di

import app.cash.sqldelight.db.SqlDriver
import com.opensource.armmpnews.db.DatabaseDriverFactory
import opensource.armmpnews.db.ARMMPNewsDB
import org.koin.dsl.module

val databaseModule = module {

    single<SqlDriver> { DatabaseDriverFactory().createDriver() }

    single<ARMMPNewsDB> { ARMMPNewsDB(get()) }
}