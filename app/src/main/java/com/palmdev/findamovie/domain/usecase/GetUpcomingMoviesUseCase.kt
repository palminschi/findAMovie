package com.palmdev.findamovie.domain.usecase

import com.palmdev.findamovie.DEFAULT_LANGUAGE
import com.palmdev.findamovie.domain.entity.MoviesPage
import com.palmdev.findamovie.domain.repository.MovieRepository

class GetUpcomingMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun invoke(
        language: String = DEFAULT_LANGUAGE,
        page: Int = 1
    ): MoviesPage? {
        return movieRepository.getUpcomingMovies(language, page)
    }

}