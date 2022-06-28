package com.palmdev.findamovie.presentation.screens.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.palmdev.findamovie.domain.entity.Movie
import com.palmdev.findamovie.domain.usecase.GetFavoriteMoviesUseCase
import kotlinx.coroutines.launch

class FavoritesViewModel(private val getFavoriteMoviesUseCase: GetFavoriteMoviesUseCase) :
    ViewModel() {
    private val _favoriteMovies = MutableLiveData<List<Movie>>()
    val favoriteMovies: LiveData<List<Movie>> = _favoriteMovies

    fun getMovies(){
        viewModelScope.launch {
            getFavoriteMoviesUseCase.invoke().collect {
                _favoriteMovies.value = it
            }
        }
    }
}