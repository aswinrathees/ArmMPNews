package com.opensource.armmpnews.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import opensource.armmpnews.db.ARMMPNewsDB

actual class DatabaseDriverFactory() {

    actual fun createDriver(): SqlDriver = NativeSqliteDriver(schema = ARMMPNewsDB.Schema, name = "ARMMPNewsDB")
}