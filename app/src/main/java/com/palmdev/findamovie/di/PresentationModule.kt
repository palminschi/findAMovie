package com.palmdev.findamovie.di

import com.palmdev.findamovie.presentation.screens.movie_details.MovieDetailsViewModel
import com.palmdev.findamovie.presentation.screens.favorites.FavoritesViewModel
import com.palmdev.findamovie.presentation.screens.main.MainViewModel
import com.palmdev.findamovie.presentation.screens.movie_bottom_sheet.MovieBottomSheetViewModel
import com.palmdev.findamovie.presentation.screens.movies_list.MoviesListViewModel
import com.palmdev.findamovie.presentation.screens.search.SearchViewModel
import com.palmdev.findamovie.presentation.screens.tv_show_details.TVShowDetailsViewModel
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
        MovieDetailsViewModel(
            getMovieDetailsUseCase = get(),
            getMovieVideoUseCase = get(),
            getMovieReviewsUseCase = get(),
            getFavoritesMoviesIDUseCase = get(),
            saveFavoriteMovieUseCase = get(),
            deleteFavoriteMovieUseCase = get(),
            getSimilarMoviesUseCase = get()
        )
    }
    viewModel {
        TVShowDetailsViewModel(
            getTVShowDetailsUseCase = get(),
            getTVShowVideoUseCase = get(),
            getTVShowReviewsUseCase = get(),
            getFavoriteTVShowsIDUseCase = get(),
            saveFavoriteTVShowUseCase = get(),
            deleteFavoriteTVShowUseCase = get(),
            getSimilarTVShowsUseCase = get()
        )
    }
    viewModel {
        FavoritesViewModel(
            getFavoriteMoviesUseCase = get(),
            getFavoriteTVShowsUseCase = get()
        )
    }
    viewModel {
        MovieBottomSheetViewModel(
            getFavoritesMoviesIDUseCase = get(),
            getFavoriteTVShowsIDUseCase = get(),
            saveFavoriteMovieUseCase = get(),
            saveFavoriteTVShowUseCase = get(),
            deleteFavoriteMovieUseCase = get(),
            deleteFavoriteTVShowUseCase = get()
        )
    }
    viewModel {
        SearchViewModel(
            searchUseCase = get()
        )
    }
    viewModel {
        MoviesListViewModel(
            getTopRatedMoviesUseCase = get(),
            getPopularMoviesUseCase = get(),
            getNowPlayingMoviesUseCase = get(),
            getUpcomingMoviesUseCase = get()
        )
    }
}