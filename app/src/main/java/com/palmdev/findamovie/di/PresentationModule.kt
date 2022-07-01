package com.palmdev.findamovie.di

import com.palmdev.findamovie.presentation.screens.details.DetailsViewModel
import com.palmdev.findamovie.presentation.screens.favorites.FavoritesViewModel
import com.palmdev.findamovie.presentation.screens.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel {
        MainViewModel(
            getUpcomingMoviesUseCase = get(),
            getNowPlayingMoviesUseCase = get(),
            getPopularMoviesUseCase = get(),
            getTopRatedMoviesUseCase = get(),
            getTopRatedTVShowsUseCase = get(),
            getPopularTVShowsUseCase = get()
        )
    }

    viewModel {
        DetailsViewModel(saveFavoriteMovieUseCase = get())
    }

    viewModel {
        FavoritesViewModel(
            getFavoriteMoviesUseCase = get(),
            get()
        )
    }
}