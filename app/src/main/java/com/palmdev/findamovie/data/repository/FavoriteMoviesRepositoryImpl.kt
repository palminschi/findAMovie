package com.palmdev.findamovie.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.palmdev.findamovie.data.database.FavoriteMoviesDao
import com.palmdev.findamovie.domain.repository.FavoriteMoviesRepository
import com.palmdev.findamovie.data.mappers.MovieMapper
import com.palmdev.findamovie.domain.entity.Movie

class FavoriteMoviesRepositoryImpl(private val favoriteMoviesDao: FavoriteMoviesDao): FavoriteMoviesRepository {

    private val movieMapper = MovieMapper()

    override val favoriteMovies: LiveData<List<Movie>>
        get() = favoriteMoviesDao.getFavoriteMovies().map { list ->
            list.map {
                movieMapper.mapToDomain( movieEntity = it )
            }
        }

    override suspend fun saveMovie(movie: Movie) {
        val movieEntity = movieMapper.mapToData(movie = movie)
        favoriteMoviesDao.saveMovie(movieEntity = movieEntity)
    }

    override suspend fun deleteMovie(movie: Movie) {
        val movieEntity = movieMapper.mapToData(movie = movie)
        favoriteMoviesDao.deleteMovie(movieEntity = movieEntity)
    }
}