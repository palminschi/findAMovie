package com.palmdev.findamovie

import android.app.Application
import com.palmdev.findamovie.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    dataModule,
                    domainModule,
                    presentationModule
                )
            )
        }

    }
}