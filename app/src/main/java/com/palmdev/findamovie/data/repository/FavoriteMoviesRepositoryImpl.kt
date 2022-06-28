package com.palmdev.findamovie.data.repository

import com.palmdev.findamovie.data.database.FavoriteMoviesDao
import com.palmdev.findamovie.data.mappers.MovieMapper
import com.palmdev.findamovie.data.storage.FavoriteMoviesIDStorage
import com.palmdev.findamovie.domain.entity.Movie
import com.palmdev.findamovie.domain.repository.FavoriteMoviesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FavoriteMoviesRepositoryImpl(
    private val favoriteMoviesDao: FavoriteMoviesDao,
    private val favoriteMoviesIDStorage: FavoriteMoviesIDStorage
) :
    FavoriteMoviesRepository {

    private val movieMapper = MovieMapper()

    override val favoriteMovies: Flow<List<Movie>>
        get() = favoriteMoviesDao.getFavoriteMovies().map { list ->
            list.map {
                movieMapper.mapToDomain(it)
            }
        }

    override suspend fun saveMovie(movie: Movie) {
        // return if it already contains this movie
        if (favoriteMoviesIDStorage.getFavoriteMoviesID()
                .contains(movie.id.toString())
        ) return

        val movieEntity = movieMapper.mapToData(movie = movie)
        favoriteMoviesDao.saveFavoriteMovie(movieEntity = movieEntity)
        favoriteMoviesIDStorage.addFavoriteMovieID(movieID = movie.id.toString())
    }

    override suspend fun deleteMovie(movieID: Int) {
        favoriteMoviesDao.deleteFavoriteMovie(id = movieID)
        favoriteMoviesIDStorage.deleteFavoriteMovieID(movieID = movieID.toString())
    }

    override fun getMoviesID(): List<String> {
        return favoriteMoviesIDStorage.getFavoriteMoviesID()
    }
}