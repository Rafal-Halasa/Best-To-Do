package com.example.besttodo

import android.app.Application
import com.example.besttodo.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BestTodoApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BestTodoApplication)
            modules(appModules)
        }
    }
}