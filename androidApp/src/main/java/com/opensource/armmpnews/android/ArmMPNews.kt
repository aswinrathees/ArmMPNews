package com.opensource.armmpnews.android

import android.app.Application
import com.opensource.armmpnews.android.di.databaseModule
import com.opensource.armmpnews.android.di.viewModelsModule
import com.opensource.armmpnews.di.sharedKoinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ArmMPNews: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        val modules = sharedKoinModules + viewModelsModule + databaseModule

        startKoin {
            androidContext(this@ArmMPNews)
            modules(modules)
        }
    }
}