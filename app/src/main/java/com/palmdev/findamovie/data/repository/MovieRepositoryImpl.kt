package com.palmdev.findamovie.data.repository

import com.palmdev.findamovie.data.mappers.*
import com.palmdev.findamovie.data.network.ApiService
import com.palmdev.findamovie.domain.entity.ListOfReviews
import com.palmdev.findamovie.domain.entity.ListOfVideos
import com.palmdev.findamovie.domain.entity.movie.MovieDetails
import com.palmdev.findamovie.domain.entity.movie.MoviesPage
import com.palmdev.findamovie.domain.entity.search.Search
import com.palmdev.findamovie.domain.repository.MovieRepository

class MovieRepositoryImpl(private val apiService: ApiService) : MovieRepository {

    private val moviesPageMapper = MoviesPageMapper()
    private val movieDetailsMapper = MovieDetailsMapper()
    private val videoMapper = VideoMapper()
    private val listOfReviewsMapper = ListOfReviewsMapper()

    override suspend fun getUpcomingMovies(
        language: String,
        page: Int
    ): MoviesPage? {
        return apiService.getUpcomingMovies(language, page).body()?.let {
            moviesPageMapper.mapToDomain(it)
        }
    }

    override suspend fun getTopRatedMovies(language: String, page: Int): MoviesPage? {
        return apiService.getTopRatedMovies(language, page).body()?.let {
            moviesPageMapper.mapToDomain(it)
        }
    }

    override suspend fun getPopularMovies(language: String, page: Int): MoviesPage? {
        return apiService.getPopularMovies(language, page).body()?.let {
            moviesPageMapper.mapToDomain(it)
        }
    }

    override suspend fun getNowPlayingMovies(language: String, page: Int): MoviesPage? {
        return apiService.getNowPlayingMovies(language, page).body()?.let {
            moviesPageMapper.mapToDomain(it)
        }
    }

    override suspend fun getSimilarMovies(movieID: Int, language: String): MoviesPage? {
        return apiService.getSimilarMovies(movieID, language).body()?.let {
            moviesPageMapper.mapToDomain(it)
        }
    }

    override suspend fun getMovieDetails(movieID: Int, language: String): MovieDetails? {
        return apiService.getMovieDetails(movieID, language).body()?.let {
            movieDetailsMapper.mapToDomain(it)
        }
    }

    override suspend fun getMovieVideos(movieID: Int, language: String): ListOfVideos? {
        return apiService.getMovieVideos(movieID, language).body()?.let {
            ListOfVideos(
                id = it.id,
                results = it.results.map { video ->
                    videoMapper.mapToDomain(video)
                }
            )
        }
    }

    override suspend fun getMovieReviews(movieID: Int, language: String): ListOfReviews? {
        val list = apiService.getMovieReviews(movieID, language).body()
        list?.let {
            if (it.total_results == 0) return null
        }
        return list?.let {
            listOfReviewsMapper.mapToDomain(it)
        }


    }

}