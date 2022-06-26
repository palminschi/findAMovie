package com.palmdev.findamovie.di

import android.app.Application
import androidx.room.Room
import com.palmdev.findamovie.DATABASE_NAME
import com.palmdev.findamovie.data.database.FavoriteMoviesDao
import com.palmdev.findamovie.data.database.FavoriteMoviesDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {

    fun provideDatabase(application: Application): FavoriteMoviesDatabase {
        return Room
            .databaseBuilder(application, FavoriteMoviesDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideDao(database: FavoriteMoviesDatabase): FavoriteMoviesDao {
        return database.getMovieDao()
    }

    single {
        provideDao(database = get())
    }

    single {
        provideDatabase(application = androidApplication())
    }


}