package com.palmdev.findamovie.di

import com.palmdev.findamovie.domain.usecase.*
import org.koin.dsl.module

val domainModule = module {

    factory {
        GetUpcomingMoviesUseCase(movieRepository = get())
    }

    factory {
        GetFavoriteMoviesUseCase(favoriteMoviesRepository = get())
    }

    factory {
        SaveFavoriteMovieUseCase(favoriteMoviesRepository = get())
    }

    factory {
        DeleteFavoriteMovieUseCase(favoriteMoviesRepository = get())
    }

    factory {
        GetFavoritesMoviesIDUseCase(favoriteMoviesRepository = get())
    }

}