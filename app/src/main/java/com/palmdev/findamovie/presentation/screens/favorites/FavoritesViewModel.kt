package com.palmdev.findamovie.presentation.screens.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.palmdev.findamovie.domain.entity.movie.Movie
import com.palmdev.findamovie.domain.usecase.GetFavoriteMoviesUseCase
import com.palmdev.findamovie.domain.usecase.SearchUseCase
import kotlinx.coroutines.launch

class FavoritesViewModel(
    private val getFavoriteMoviesUseCase: GetFavoriteMoviesUseCase,
    private val searchUseCase: SearchUseCase
) :
    ViewModel() {
    private val _favoriteMovies = MutableLiveData<List<Movie>>()
    val favoriteMovies: LiveData<List<Movie>> = _favoriteMovies

    fun getMovies() {
        viewModelScope.launch {
            getFavoriteMoviesUseCase.invoke().collect {
                _favoriteMovies.value = it
            }
        }
    }

    init {
        viewModelScope.launch {
            val response = searchUseCase.invoke(query = "Tom Ha")
            response?.results
        }
    }
}