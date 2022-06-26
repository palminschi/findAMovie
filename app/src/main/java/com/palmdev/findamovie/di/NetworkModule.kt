package com.palmdev.findamovie.di

import com.palmdev.findamovie.BASE_URL
import com.palmdev.findamovie.data.network.ApiService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    fun provideApi(): ApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(ApiService::class.java)
    }

    single {
        provideApi()
    }

}