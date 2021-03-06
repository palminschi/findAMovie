package com.palmdev.findamovie.domain.usecase.movie

import com.palmdev.findamovie.DEFAULT_LANGUAGE
import com.palmdev.findamovie.domain.entity.ListOfReviews
import com.palmdev.findamovie.domain.repository.MovieRepository

class GetMovieReviewsUseCase(private val movieRepository: MovieRepository) {

    suspend fun invoke(movieID: Int, language: String = DEFAULT_LANGUAGE): ListOfReviews? {
        var reviews = movieRepository.getMovieReviews(movieID, language)
        if (reviews == null) reviews = movieRepository.getMovieReviews(movieID, DEFAULT_LANGUAGE)
        return reviews
    }

}