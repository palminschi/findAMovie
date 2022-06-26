package com.palmdev.findamovie.data.repository

import com.palmdev.findamovie.data.mappers.MoviesPageMapper
import com.palmdev.findamovie.data.network.ApiService
import com.palmdev.findamovie.data.network.RetrofitInstance
import com.palmdev.findamovie.domain.entity.MoviesPage
import com.palmdev.findamovie.domain.repository.MovieRepository

class MovieRepositoryImpl(private val apiService: ApiService) : MovieRepository {

    private val moviesPageMapper = MoviesPageMapper()

    override suspend fun getUpcomingMovies(): MoviesPage? {
        return apiService.getUpcomingMovies().body()?.let {
                moviesPageMapper.mapToDomain(it)
            }
    }
}