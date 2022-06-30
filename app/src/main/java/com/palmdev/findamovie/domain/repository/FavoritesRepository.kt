package com.palmdev.findamovie.domain.repository

import com.palmdev.findamovie.domain.entity.movie.Movie
import com.palmdev.findamovie.domain.entity.tvshow.TVShow
import kotlinx.coroutines.flow.Flow

interface FavoritesRepository {

    val favoriteMovies: Flow<List<Movie>>
    val favoriteMoviesID: List<String>
    val favoriteTVShowsID: List<String>

    suspend fun saveMovie(movie: Movie)

    suspend fun deleteMovie(movieID: Int)

    suspend fun saveTVShow(tvShow: TVShow)

    suspend fun deleteTVShow(tvID: Int)

    suspend fun deleteAll()

}