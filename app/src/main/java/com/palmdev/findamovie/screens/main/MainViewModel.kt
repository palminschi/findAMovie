package com.palmdev.findamovie.screens.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.palmdev.findamovie.data.retrofit.RetrofitRepository
import com.palmdev.findamovie.models.MoviesPage
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel : ViewModel() {

    private val retrofitRepository = RetrofitRepository()
    private val _upcomingMovies = MutableLiveData<Response<MoviesPage>>()
    val upcomingMovies: LiveData<Response<MoviesPage>> = _upcomingMovies

    fun getUpcomingMovies() {
        viewModelScope.launch {
            _upcomingMovies.value = retrofitRepository.getUpcomingMovies()
        }
    }
}