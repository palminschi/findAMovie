package com.palmdev.findamovie.di

import com.palmdev.findamovie.domain.usecase.DeleteFavoriteMovieUseCase
import com.palmdev.findamovie.domain.usecase.GetFavoriteMoviesUseCase
import com.palmdev.findamovie.domain.usecase.GetUpcomingMoviesUseCase
import com.palmdev.findamovie.domain.usecase.SaveFavoriteMovieUseCase
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

}