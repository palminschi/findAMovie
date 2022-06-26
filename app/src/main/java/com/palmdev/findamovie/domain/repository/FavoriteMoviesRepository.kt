package com.palmdev.findamovie.domain.repository

import androidx.lifecycle.LiveData
import com.palmdev.findamovie.data.entity.MovieEntity
import com.palmdev.findamovie.domain.entity.Movie

interface FavoriteMoviesRepository {

    val favoriteMovies: LiveData<List<Movie>>

    suspend fun saveMovie(movie: Movie)

    suspend fun deleteMovie(movie: Movie)
}