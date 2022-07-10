package com.palmdev.findamovie.di

import androidx.room.Room
import com.palmdev.findamovie.DATABASE_NAME
import com.palmdev.findamovie.MAIN
import com.palmdev.findamovie.data.database.FavoriteMoviesDao
import com.palmdev.findamovie.data.database.FavoriteTVShowsDao
import com.palmdev.findamovie.data.database.FavoritesDatabase
import org.koin.dsl.module

val databaseModule = module {

    fun provideDatabase(): FavoritesDatabase {
        return Room
            .databaseBuilder(MAIN, FavoritesDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideMoviesDao(database: FavoritesDatabase): FavoriteMoviesDao {
        return database.favoriteMoviesDao()
    }

    fun provideTVShowsDao(database: FavoritesDatabase): FavoriteTVShowsDao {
        return database.favoriteTVShowsDao()
    }

    single<FavoritesDatabase> {
        provideDatabase()
    }

    single<FavoriteMoviesDao> {
        provideMoviesDao(database = get())
    }

    single<FavoriteTVShowsDao> {
        provideTVShowsDao(database = get())
    }



}