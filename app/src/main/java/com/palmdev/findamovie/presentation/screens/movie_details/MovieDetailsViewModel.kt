package com.palmdev.findamovie.presentation.screens.movie_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.palmdev.findamovie.Const
import com.palmdev.findamovie.domain.entity.ListOfReviews
import com.palmdev.findamovie.domain.entity.VideoInfo
import com.palmdev.findamovie.domain.entity.movie.Movie
import com.palmdev.findamovie.domain.entity.movie.MovieDetails
import com.palmdev.findamovie.domain.entity.movie.MoviesPage
import com.palmdev.findamovie.domain.entity.tvshow.TVShow
import com.palmdev.findamovie.domain.entity.tvshow.TVShowDetails
import com.palmdev.findamovie.domain.usecase.movie.*
import com.palmdev.findamovie.domain.usecase.tvshow.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieDetailsViewModel(
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase,
    private val getMovieVideoUseCase: GetMovieVideoUseCase,
    private val getMovieReviewsUseCase: GetMovieReviewsUseCase,
    private val getFavoritesMoviesIDUseCase: GetFavoritesMoviesIDUseCase,
    private val saveFavoriteMovieUseCase: SaveFavoriteMovieUseCase,
    private val deleteFavoriteMovieUseCase: DeleteFavoriteMovieUseCase,
    private val getSimilarMoviesUseCase: GetSimilarMoviesUseCase
) : ViewModel() {

    private val _movieDetails = MutableLiveData<MovieDetails>()
    val movieDetails: LiveData<MovieDetails> = _movieDetails
    private val _movieVideo = MutableLiveData<VideoInfo>()
    val movieVideo: LiveData<VideoInfo> = _movieVideo
    private val _movieReviews = MutableLiveData<ListOfReviews>()
    val movieReview: LiveData<ListOfReviews> = _movieReviews
    private val _favoriteMoviesID = MutableLiveData<List<String>>()
    val favoriteMoviesID: LiveData<List<String>> = _favoriteMoviesID
    private val _similarMovies = MutableLiveData<MoviesPage>()
    val similarMovies: LiveData<MoviesPage> = _similarMovies

    init {
        viewModelScope.launch {
            _favoriteMoviesID.value = getFavoritesMoviesIDUseCase.invoke()
        }
    }

    fun initMovie(id: Int) {
        viewModelScope.launch {
            _movieDetails.value = getMovieDetailsUseCase.invoke(
                movieID = id,
                language = Const.getUserLanguage()
            )
            _movieVideo.value = getMovieVideoUseCase.invoke(
                movieID = id,
                language = Const.getUserLanguage()
            )
            _movieReviews.value = getMovieReviewsUseCase.invoke(
                movieID = id,
                language = Const.getUserLanguage()
            )
        }
    }

    fun saveMovie(movie: Movie) {
        viewModelScope.launch(Dispatchers.IO) {
            saveFavoriteMovieUseCase.invoke(movie)
        }
    }

    fun deleteMovie(movieID: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteFavoriteMovieUseCase.invoke(movieID)
        }
    }

    fun getSimilarMovies(movieID: Int) {
        viewModelScope.launch {
            _similarMovies.value = getSimilarMoviesUseCase.invoke(movieID, Const.getUserLanguage())
        }
    }
}