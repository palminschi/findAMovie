package com.palmdev.findamovie.domain.repository

import com.palmdev.findamovie.domain.entity.tvshow.TVShow
import kotlinx.coroutines.flow.Flow

interface FavoritesRepository {

    val favoriteMovies: Flow<List<com.palmdev.findamovie.domain.entity.movie.Movie>>
    val favoriteTVShows: Flow<List<TVShow>>
    val favoriteMoviesID: List<String>
    val favoriteTVShowsID: List<String>

    suspend fun saveMovie(movie: com.palmdev.findamovie.domain.entity.movie.Movie)

    suspend fun deleteMovie(movieID: Int)

    suspend fun saveTVShow(tvShow: TVShow)

    suspend fun deleteTVShow(tvID: Int)

    suspend fun deleteAll()

}