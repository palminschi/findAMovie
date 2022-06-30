package com.palmdev.findamovie.di

import com.palmdev.findamovie.domain.usecase.*
import org.koin.dsl.module

val domainModule = module {

    factory {
        GetUpcomingMoviesUseCase(movieRepository = get())
    }

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
        SearchUseCase(searchRepository = get())
    }

}