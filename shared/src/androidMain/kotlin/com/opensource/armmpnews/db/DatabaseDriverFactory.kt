package com.opensource.armmpnews.db

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import opensource.armmpnews.db.ARMMPNewsDB

actual class DatabaseDriverFactory(private val context: Context) {

    actual fun createDriver(): SqlDriver = AndroidSqliteDriver(
        schema = ARMMPNewsDB.Schema,
        context = context,
        name = "ArmMPNewsDB"
    )
}