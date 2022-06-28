package com.palmdev.findamovie.di

import androidx.room.Room
import com.palmdev.findamovie.DATABASE_NAME
import com.palmdev.findamovie.MAIN
import com.palmdev.findamovie.data.database.FavoriteMoviesDao
import com.palmdev.findamovie.data.database.FavoriteMoviesDatabase
import org.koin.dsl.module

val databaseModule = module {

    fun provideDatabase(): FavoriteMoviesDatabase {
        return Room
            .databaseBuilder(MAIN, FavoriteMoviesDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideDao(database: FavoriteMoviesDatabase): FavoriteMoviesDao {
        return database.favoriteMoviesDao()
    }

    single<FavoriteMoviesDatabase> {
        provideDatabase()
    }

    single<FavoriteMoviesDao> {
        provideDao(database = get())
    }




}