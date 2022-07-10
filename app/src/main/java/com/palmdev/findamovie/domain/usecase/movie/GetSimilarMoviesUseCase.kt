package com.palmdev.findamovie.domain.usecase.movie

import com.palmdev.findamovie.DEFAULT_LANGUAGE
import com.palmdev.findamovie.domain.entity.movie.MoviesPage
import com.palmdev.findamovie.domain.repository.MovieRepository

class GetSimilarMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun invoke(
        movieID: Int,
        language: String = DEFAULT_LANGUAGE
    ): MoviesPage? {
        return movieRepository.getSimilarMovies(movieID, language)
    }

}