package com.example.besttodo

import android.app.Application
import com.example.besttodo.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BestTodoApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BestTodoApplication)
            modules(
                viewModelsModules,
                dbModules,
                repositoriesModules,
                servicesModules,
                appModules,
                adapters,
                viewBinding
            )
        }
    }
}