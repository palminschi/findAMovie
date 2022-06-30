package com.palmdev.findamovie.domain.usecase.tvshow

import com.palmdev.findamovie.DEFAULT_LANGUAGE
import com.palmdev.findamovie.domain.entity.ListOfReviews
import com.palmdev.findamovie.domain.repository.TVShowRepository

class GetTVShowReviewsUseCase(private val tvShowRepository: TVShowRepository) {

    suspend fun invoke(
        tvID: Int,
        language: String = DEFAULT_LANGUAGE
    ): ListOfReviews? {
        return tvShowRepository.getTVShowReviews(tvID, language)
    }

}