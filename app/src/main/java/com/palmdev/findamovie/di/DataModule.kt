package com.palmdev.findamovie.di

import com.palmdev.findamovie.data.repository.FavoriteMoviesRepositoryImpl
import com.palmdev.findamovie.data.repository.MovieRepositoryImpl
import com.palmdev.findamovie.domain.repository.FavoriteMoviesRepository
import com.palmdev.findamovie.domain.repository.MovieRepository
import org.koin.dsl.module

val dataModule = module {

    single<FavoriteMoviesRepository> {
        FavoriteMoviesRepositoryImpl(favoriteMoviesDao = get())
    }

    single<MovieRepository> {
        MovieRepositoryImpl(apiService = get())
    }

}