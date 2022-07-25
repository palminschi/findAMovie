package com.palmdev.findamovie

import android.app.Application
import android.util.Log
import com.google.android.gms.tasks.Task
import com.google.firebase.FirebaseApp
import com.google.firebase.messaging.FirebaseMessaging
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

        // Firebase init
        FirebaseApp.initializeApp(this)
        // Firebase Messaging init
        FirebaseMessaging.getInstance().token
            .addOnCompleteListener { task: Task<String> ->
                if (!task.isSuccessful) {
                    return@addOnCompleteListener
                }
                val token = task.result
                Log.d("TAG", "Token ->$token")
            }

    }
}