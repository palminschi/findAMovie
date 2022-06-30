package com.palmdev.findamovie.presentation.screens.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.palmdev.findamovie.Const
import com.palmdev.findamovie.domain.entity.movie.MoviesPage
import com.palmdev.findamovie.domain.usecase.GetUpcomingMoviesUseCase
import kotlinx.coroutines.launch

class MainViewModel(private val getUpcomingMoviesUseCase: GetUpcomingMoviesUseCase) : ViewModel() {

    private val _upcomingMovies = MutableLiveData<MoviesPage>()
    val upcomingMovies: LiveData<MoviesPage> = _upcomingMovies

    fun getUpcomingMovies() {
        viewModelScope.launch {
            _upcomingMovies.value = getUpcomingMoviesUseCase.invoke(language = Const.getUserLanguage())
        }
    }
}