package com.palmdev.findamovie.presentation.screens.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.palmdev.findamovie.domain.entity.movie.Movie
import com.palmdev.findamovie.domain.entity.tvshow.TVShow
import com.palmdev.findamovie.domain.usecase.movie.GetFavoriteMoviesUseCase
import com.palmdev.findamovie.domain.usecase.SearchUseCase
import com.palmdev.findamovie.domain.usecase.tvshow.GetFavoriteTVShowsUseCase
import kotlinx.coroutines.launch

class FavoritesViewModel(
    private val getFavoriteMoviesUseCase: GetFavoriteMoviesUseCase,
    private val getFavoriteTVShowsUseCase: GetFavoriteTVShowsUseCase
) : ViewModel() {

    private val _favoriteMovies = MutableLiveData<List<Movie>>()
    val favoriteMovies: LiveData<List<Movie>> = _favoriteMovies
    private val _favoriteTVShows = MutableLiveData<List<TVShow>>()
    val favoriteTVShows: LiveData<List<TVShow>> = _favoriteTVShows

    fun getFavorites() {
        viewModelScope.launch {
            getFavoriteMoviesUseCase.invoke().collect {
                _favoriteMovies.value = it
            }
        }
        viewModelScope.launch {
            getFavoriteTVShowsUseCase.invoke().collect {
                _favoriteTVShows.value = it
            }
        }
    }

}