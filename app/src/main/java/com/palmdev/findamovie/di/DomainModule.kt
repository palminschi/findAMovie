package com.palmdev.findamovie.di

import com.palmdev.findamovie.domain.usecase.GetUpcomingMoviesUseCase
import org.koin.dsl.module

val domainModule = module {

    factory {
        GetUpcomingMoviesUseCase(movieRepository = get())
    }
}