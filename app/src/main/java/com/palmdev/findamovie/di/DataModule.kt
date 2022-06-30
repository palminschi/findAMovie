package com.palmdev.findamovie.di

import com.palmdev.findamovie.data.repository.FavoritesRepositoryImpl
import com.palmdev.findamovie.data.repository.MovieRepositoryImpl
import com.palmdev.findamovie.data.repository.SearchRepositoryImpl
import com.palmdev.findamovie.data.repository.TVShowRepositoryImpl
import com.palmdev.findamovie.data.storage.FavoriteMoviesIDStorage
import com.palmdev.findamovie.domain.repository.FavoritesRepository
import com.palmdev.findamovie.domain.repository.MovieRepository
import com.palmdev.findamovie.domain.repository.SearchRepository
import com.palmdev.findamovie.domain.repository.TVShowRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataModule = module {

    single<FavoritesRepository> {
        FavoritesRepositoryImpl(
            favoriteMoviesDao = get(),
            favoriteMoviesIDStorage = get()
        )
    }

    single<MovieRepository> {
        MovieRepositoryImpl(apiService = get())
    }

    single<TVShowRepository> {
        TVShowRepositoryImpl(apiService = get())
    }

    single<SearchRepository> {
        SearchRepositoryImpl(apiService = get())
    }

    single {
        FavoriteMoviesIDStorage(context = androidApplication())
    }

}