package com.palmdev.findamovie.data.repository

import com.palmdev.findamovie.data.database.FavoriteMoviesDao
import com.palmdev.findamovie.data.database.FavoriteTVShowsDao
import com.palmdev.findamovie.data.mappers.MovieMapper
import com.palmdev.findamovie.data.mappers.TVShowMapper
import com.palmdev.findamovie.data.storage.FavoriteMoviesIDStorage
import com.palmdev.findamovie.data.storage.FavoriteTVShowsIDStorage
import com.palmdev.findamovie.domain.entity.movie.Movie
import com.palmdev.findamovie.domain.entity.tvshow.TVShow
import com.palmdev.findamovie.domain.repository.FavoritesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FavoritesRepositoryImpl(
    private val favoriteMoviesDao: FavoriteMoviesDao,
    private val favoriteTVShowsDao: FavoriteTVShowsDao,
    private val favoriteMoviesIDStorage: FavoriteMoviesIDStorage,
    private val favoriteTVShowsIDStorage: FavoriteTVShowsIDStorage
) : FavoritesRepository {

    private val movieMapper = MovieMapper()
    private val tvShowMapper = TVShowMapper()

    override val favoriteMovies: Flow<List<Movie>>
        get() = favoriteMoviesDao.getFavoriteMovies().map { list ->
            list.map {
                movieMapper.mapToDomain(it)
            }
        }

    override val favoriteMoviesID: List<String>
        get() = favoriteMoviesIDStorage.getFavoriteMoviesID()

    override val favoriteTVShowsID: List<String>
        get() = favoriteTVShowsIDStorage.getFavoriteTVShowsID()

    override suspend fun saveMovie(movie: Movie) {
        // return if it already contains this movie
        if (favoriteMoviesIDStorage.getFavoriteMoviesID()
                .contains(movie.id.toString())
        ) return

        val movieDto = movieMapper.mapToData(domainModel = movie)
        favoriteMoviesDao.saveFavoriteMovie(movieDto = movieDto)
        favoriteMoviesIDStorage.addFavoriteMovieID(movieID = movie.id.toString())
    }

    override suspend fun deleteMovie(movieID: Int) {
        favoriteMoviesDao.deleteFavoriteMovie(id = movieID)
        favoriteMoviesIDStorage.deleteFavoriteMovieID(movieID = movieID.toString())
    }

    override suspend fun saveTVShow(tvShow: TVShow) {
        if (favoriteMoviesIDStorage.getFavoriteMoviesID().contains(tvShow.id.toString())) return

        val tvShowDto = tvShowMapper.mapToData(domainModel = tvShow)
        favoriteTVShowsDao.saveFavoriteTVShow(tvShowDto)
        favoriteTVShowsIDStorage.addFavoriteTVShowID(tvID = tvShowDto.id.toString())
    }

    override suspend fun deleteTVShow(tvID: Int) {
        favoriteTVShowsDao.deleteFavoriteTVShow(id = tvID)
        favoriteTVShowsIDStorage.deleteFavoriteTVShowID(tvID = tvID.toString())
    }

    override suspend fun deleteAll() {
        favoriteTVShowsIDStorage.deleteAll()
        favoriteMoviesIDStorage.deleteAll()
        favoriteTVShowsDao.deleteAll()
        favoriteMoviesDao.deleteAll()
    }
}