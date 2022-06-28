package com.palmdev.findamovie.data.repository

import com.palmdev.findamovie.data.database.FavoriteMoviesDao
import com.palmdev.findamovie.data.mappers.MovieMapper
import com.palmdev.findamovie.domain.entity.Movie
import com.palmdev.findamovie.domain.repository.FavoriteMoviesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FavoriteMoviesRepositoryImpl(private val favoriteMoviesDao: FavoriteMoviesDao) :
    FavoriteMoviesRepository {

    private val movieMapper = MovieMapper()

    override val favoriteMovies: Flow<List<Movie>>
        get() = favoriteMoviesDao.getFavoriteMovies().map { list ->
            list.map {
                movieMapper.mapToDomain(it)
            }
        }

    override suspend fun saveMovie(movie: Movie) {
        val movieEntity = movieMapper.mapToData(movie = movie)
        favoriteMoviesDao.saveFavoriteMovie(movieEntity = movieEntity)
    }

    override suspend fun deleteMovie(movieID: Int) {
        favoriteMoviesDao.deleteFavoriteMovie(id = movieID)
    }
}