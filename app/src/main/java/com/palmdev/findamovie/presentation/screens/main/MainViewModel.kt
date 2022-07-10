package com.palmdev.findamovie.presentation.screens.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.palmdev.findamovie.Const
import com.palmdev.findamovie.domain.entity.movie.MoviesPage
import com.palmdev.findamovie.domain.entity.movie.Movie
import com.palmdev.findamovie.domain.entity.tvshow.TVShowsPage
import com.palmdev.findamovie.domain.usecase.movie.GetNowPlayingMoviesUseCase
import com.palmdev.findamovie.domain.usecase.movie.GetPopularMoviesUseCase
import com.palmdev.findamovie.domain.usecase.movie.GetTopRatedMoviesUseCase
import com.palmdev.findamovie.domain.usecase.movie.GetUpcomingMoviesUseCase
import com.palmdev.findamovie.domain.usecase.tvshow.GetPopularTVShowsUseCase
import com.palmdev.findamovie.domain.usecase.tvshow.GetTopRatedTVShowsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val getUpcomingMoviesUseCase: GetUpcomingMoviesUseCase,
    private val getNowPlayingMoviesUseCase: GetNowPlayingMoviesUseCase,
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase,
    private val getTopRatedTVShowsUseCase: GetTopRatedTVShowsUseCase,
    private val getPopularTVShowsUseCase: GetPopularTVShowsUseCase
    ) : ViewModel() {

    private val _upcomingMovies = MutableLiveData<MoviesPage>()
    val upcomingMovies: LiveData<MoviesPage> = _upcomingMovies

    private val _nowPlayingMovies = MutableLiveData<MoviesPage>()
    val nowPlayingMovies: LiveData<MoviesPage> = _nowPlayingMovies

    private val _topRatedMovies = MutableLiveData<MoviesPage>()
    val topRatedMovies: LiveData<MoviesPage> = _topRatedMovies

    private val _popularMovies = MutableLiveData<MoviesPage>()
    val popularMovies: LiveData<MoviesPage> = _popularMovies

    private val _topRatedTVShows = MutableLiveData<TVShowsPage>()
    val topRatedTVShows: LiveData<TVShowsPage> = _topRatedTVShows

    private val _popularTVShows = MutableLiveData<TVShowsPage>()
    val popularTVShows: LiveData<TVShowsPage> = _popularTVShows

    fun getMovies() {
        viewModelScope.launch {
            _upcomingMovies.value = getUpcomingMoviesUseCase.invoke(language = Const.getUserLanguage())
        }
        viewModelScope.launch {
            _nowPlayingMovies.value = getNowPlayingMoviesUseCase.invoke(language = Const.getUserLanguage())
        }
        viewModelScope.launch {
            _popularTVShows.value = getPopularTVShowsUseCase.invoke(language = Const.getUserLanguage())
        }
        viewModelScope.launch {
            _topRatedTVShows.value = getTopRatedTVShowsUseCase.invoke(language = Const.getUserLanguage())
        }
        viewModelScope.launch {
            _topRatedMovies.value = getTopRatedMoviesUseCase.invoke(language = Const.getUserLanguage())
        }
        viewModelScope.launch {
            _popularMovies.value = getPopularMoviesUseCase.invoke(language = Const.getUserLanguage())
        }
    }
}