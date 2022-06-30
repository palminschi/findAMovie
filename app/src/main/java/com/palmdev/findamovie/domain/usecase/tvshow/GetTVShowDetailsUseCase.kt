package com.palmdev.findamovie.domain.usecase.tvshow

import com.palmdev.findamovie.DEFAULT_LANGUAGE
import com.palmdev.findamovie.domain.entity.tvshow.TVShowDetails
import com.palmdev.findamovie.domain.repository.TVShowRepository

class GetTVShowDetailsUseCase(private val tvShowRepository: TVShowRepository) {

    suspend fun invoke(tvID: Int, language: String = DEFAULT_LANGUAGE): TVShowDetails? {
        return tvShowRepository.getTVShowDetails(
            tvID = tvID,
            language = language
        )
    }
}
