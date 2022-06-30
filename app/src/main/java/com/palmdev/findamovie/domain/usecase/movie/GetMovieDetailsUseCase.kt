package com.palmdev.findamovie.domain.usecase.movie

import com.palmdev.findamovie.DEFAULT_LANGUAGE
import com.palmdev.findamovie.domain.entity.movie.MovieDetails
import com.palmdev.findamovie.domain.repository.MovieRepository

class GetMovieDetailsUseCase(private val movieRepository: MovieRepository) {

    suspend fun invoke(movieID: Int, language: String = DEFAULT_LANGUAGE): MovieDetails? {
        return movieRepository.getMovieDetails(
            movieID = movieID,
            language = language
        )
    }

}
