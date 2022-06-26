package com.palmdev.findamovie.di

import com.palmdev.findamovie.presentation.screens.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel {
        MainViewModel(getUpcomingMoviesUseCase = get())
    }
}