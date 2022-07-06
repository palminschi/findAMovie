package com.palmdev.findamovie.presentation.screens.movie_bottom_sheet

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.palmdev.findamovie.domain.entity.movie.Movie
import com.palmdev.findamovie.domain.entity.tvshow.TVShow
import com.palmdev.findamovie.domain.usecase.movie.DeleteFavoriteMovieUseCase
import com.palmdev.findamovie.domain.usecase.movie.GetFavoritesMoviesIDUseCase
import com.palmdev.findamovie.domain.usecase.movie.SaveFavoriteMovieUseCase
import com.palmdev.findamovie.domain.usecase.tvshow.DeleteFavoriteTVShowUseCase
import com.palmdev.findamovie.domain.usecase.tvshow.GetFavoriteTVShowsIDUseCase
import com.palmdev.findamovie.domain.usecase.tvshow.SaveFavoriteTVShowUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieBottomSheetViewModel(
    private val getFavoriteTVShowsIDUseCase: GetFavoriteTVShowsIDUseCase,
    private val getFavoritesMoviesIDUseCase: GetFavoritesMoviesIDUseCase,
    private val saveFavoriteTVShowUseCase: SaveFavoriteTVShowUseCase,
    private val saveFavoriteMovieUseCase: SaveFavoriteMovieUseCase,
    private val deleteFavoriteTVShowUseCase: DeleteFavoriteTVShowUseCase,
    private val deleteFavoriteMovieUseCase: DeleteFavoriteMovieUseCase
) : ViewModel() {

    private val _favoriteMoviesID = MutableLiveData<List<String>>()
    val favoriteMoviesID: LiveData<List<String>> = _favoriteMoviesID
    private val _favoriteTVShowsID = MutableLiveData<List<String>>()
    val favoriteTVShowsID: LiveData<List<String>> = _favoriteTVShowsID

    init {
        viewModelScope.launch {
            _favoriteMoviesID.value = getFavoritesMoviesIDUseCase.invoke()
        }
        viewModelScope.launch {
            _favoriteTVShowsID.value = getFavoriteTVShowsIDUseCase.invoke()
        }
    }

    fun saveMovie(movie: Movie) {
        viewModelScope.launch (Dispatchers.IO) {
            saveFavoriteMovieUseCase.invoke(movie)
        }
    }

    fun saveTVShow(tvShow: TVShow) {
        viewModelScope.launch (Dispatchers.IO) {
            saveFavoriteTVShowUseCase.invoke(tvShow)
        }
    }

    fun deleteMovie(movieID: Int) {
        viewModelScope.launch (Dispatchers.IO) {
            deleteFavoriteMovieUseCase.invoke(movieID)
        }
    }

    fun deleteTVShow(tvID: Int) {
        viewModelScope.launch (Dispatchers.IO) {
            deleteFavoriteTVShowUseCase.invoke(tvID)
        }
    }
}