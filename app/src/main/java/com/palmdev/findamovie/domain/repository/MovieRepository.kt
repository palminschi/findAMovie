package com.palmdev.findamovie.domain.repository

import com.palmdev.findamovie.domain.entity.ListOfReviews
import com.palmdev.findamovie.domain.entity.ListOfVideos
import com.palmdev.findamovie.domain.entity.movie.MovieDetails
import com.palmdev.findamovie.domain.entity.movie.MoviesPage
import com.palmdev.findamovie.domain.entity.search.Search

interface MovieRepository {

    suspend fun getUpcomingMovies(language: String, page: Int): MoviesPage?

    suspend fun getTopRatedMovies(language: String, page: Int): MoviesPage?

    suspend fun getPopularMovies(language: String, page: Int): MoviesPage?

    suspend fun getNowPlayingMovies(language: String, page: Int): MoviesPage?

    suspend fun getSimilarMovies(movieID: Int, language: String): MoviesPage?

    suspend fun getMovieDetails(movieID: Int, language: String): MovieDetails?

    suspend fun getMovieVideos(movieID: Int, language: String): ListOfVideos?

    suspend fun getMovieReviews(movieID: Int, language: String): ListOfReviews?

}