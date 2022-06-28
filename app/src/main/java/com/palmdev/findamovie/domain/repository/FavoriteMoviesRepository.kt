package com.palmdev.findamovie.domain.repository

import com.palmdev.findamovie.domain.entity.Movie
import kotlinx.coroutines.flow.Flow

interface FavoriteMoviesRepository {

    val favoriteMovies: Flow<List<Movie>>

    suspend fun saveMovie(movie: Movie)

    suspend fun deleteMovie(movieID: Int)
}