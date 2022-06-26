package com.palmdev.findamovie.domain.usecase

import com.palmdev.findamovie.domain.entity.MoviesPage
import com.palmdev.findamovie.domain.repository.MovieRepository

class GetUpcomingMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun invoke(): MoviesPage? {
        return movieRepository.getUpcomingMovies()
    }

}