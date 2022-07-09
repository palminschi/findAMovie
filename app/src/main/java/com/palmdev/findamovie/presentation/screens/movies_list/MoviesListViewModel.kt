package com.palmdev.findamovie.presentation.screens.movies_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.palmdev.findamovie.Const
import com.palmdev.findamovie.domain.entity.movie.MoviesPage
import com.palmdev.findamovie.domain.usecase.movie.GetNowPlayingMoviesUseCase
import com.palmdev.findamovie.domain.usecase.movie.GetPopularMoviesUseCase
import com.palmdev.findamovie.domain.usecase.movie.GetTopRatedMoviesUseCase
import com.palmdev.findamovie.domain.usecase.movie.GetUpcomingMoviesUseCase
import kotlinx.coroutines.launch

class MoviesListViewModel(
    private val getUpcomingMoviesUseCase: GetUpcomingMoviesUseCase,
    private val getNowPlayingMoviesUseCase: GetNowPlayingMoviesUseCase,
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase,
) : ViewModel() {

    private val _upcomingMovies = MutableLiveData<MoviesPage>()
    val upcomingMovies: LiveData<MoviesPage> = _upcomingMovies

    private val _nowPlayingMovies = MutableLiveData<MoviesPage>()
    val nowPlayingMovies: LiveData<MoviesPage> = _nowPlayingMovies

    private val _topRatedMovies = MutableLiveData<MoviesPage>()
    val topRatedMovies: LiveData<MoviesPage> = _topRatedMovies

    private val _popularMovies = MutableLiveData<MoviesPage>()
    val popularMovies: LiveData<MoviesPage> = _popularMovies

    fun getUpcomingMovies(page: Int = 1) {
        viewModelScope.launch {
            _upcomingMovies.value =
                getUpcomingMoviesUseCase.invoke(language = Const.getUserLanguage(), page = page)
        }
    }

    fun getNowPlayingMovies(page: Int = 1) {
        viewModelScope.launch {
            _nowPlayingMovies.value =
                getNowPlayingMoviesUseCase.invoke(language = Const.getUserLanguage(), page = page)
        }
    }

    fun getTopRatedMovies(page: Int = 1) {
        viewModelScope.launch {
            _topRatedMovies.value =
                getTopRatedMoviesUseCase.invoke(language = Const.getUserLanguage(), page = page)
        }
    }

    fun getPopularMovies(page: Int = 1) {
        viewModelScope.launch {
            _popularMovies.value =
                getPopularMoviesUseCase.invoke(language = Const.getUserLanguage(), page = page)
        }
    }
}