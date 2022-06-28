package com.palmdev.findamovie.presentation.screens.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.palmdev.findamovie.domain.entity.Movie
import com.palmdev.findamovie.domain.usecase.SaveFavoriteMovieUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailsViewModel(private val saveFavoriteMovieUseCase: SaveFavoriteMovieUseCase) :
    ViewModel() {

    fun saveMovie(movie: Movie) {
        viewModelScope.launch(Dispatchers.IO) {
            saveFavoriteMovieUseCase.invoke(movie = movie)
        }
    }
}