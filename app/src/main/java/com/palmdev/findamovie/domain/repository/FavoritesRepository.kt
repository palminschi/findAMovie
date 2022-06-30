package com.palmdev.findamovie.domain.repository

import com.palmdev.findamovie.domain.entity.movie.Movie
import kotlinx.coroutines.flow.Flow

interface FavoritesRepository {

    val favoriteMovies: Flow<List<Movie>>

    suspend fun saveMovie(movie: Movie)

    suspend fun deleteMovie(movieID: Int)

    fun getMoviesID(): List<String>
}