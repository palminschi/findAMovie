package com.palmdev.findamovie.di

import com.palmdev.findamovie.domain.usecase.*
import com.palmdev.findamovie.domain.usecase.movie.*
import com.palmdev.findamovie.domain.usecase.tvshow.*
import org.koin.dsl.module

val domainModule = module {


    // Search UseCases:
    factory {
        SearchUseCase(searchRepository = get())
    }
    // Movie UseCases:
    factory {
        GetFavoriteMoviesUseCase(favoritesRepository = get())
    }
    factory {
        SaveFavoriteMovieUseCase(favoritesRepository = get())
    }
    factory {
        DeleteFavoriteMovieUseCase(favoritesRepository = get())
    }
    factory {
        GetFavoritesMoviesIDUseCase(favoritesRepository = get())
    }
    factory {
        GetMovieDetailsUseCase(movieRepository = get())
    }
    factory {
        GetUpcomingMoviesUseCase(movieRepository = get())
    }
    factory {
        GetMovieReviewsUseCase(movieRepository = get())
    }
    factory {
        GetMovieVideoUseCase(movieRepository = get())
    }
    factory {
        GetNowPlayingMoviesUseCase(movieRepository = get())
    }
    factory {
        GetPopularMoviesUseCase(movieRepository = get())
    }
    factory {
        GetSimilarMoviesUseCase(movieRepository = get())
    }
    factory {
        GetTopRatedMoviesUseCase(movieRepository = get())
    }
    // TVShows UseCases:
    factory {
        DeleteFavoriteTVShowUseCase(favoritesRepository = get())
    }
    factory {
        GetFavoriteTVShowsIDUseCase(favoritesRepository = get())
    }
    factory {
        GetFavoriteTVShowsUseCase(favoritesRepository = get())
    }
    factory {
        GetPopularTVShowsUseCase(tvShowRepository = get())
    }
    factory {
        GetSimilarTVShowsUseCase(tvShowRepository = get())
    }
    factory {
        GetTopRatedTVShowsUseCase(tvShowRepository = get())
    }
    factory {
        GetTVShowDetailsUseCase(tvShowRepository = get())
    }
    factory {
        GetTVShowReviewsUseCase(tvShowRepository = get())
    }
    factory {
        GetTVShowVideoUseCase(tvShowRepository = get())
    }
    factory {
        SaveFavoriteTVShowUseCase(favoritesRepository = get())
    }
    // Other
    factory {
        DeleteAllFavoritesUseCase(favoritesRepository = get())
    }

}