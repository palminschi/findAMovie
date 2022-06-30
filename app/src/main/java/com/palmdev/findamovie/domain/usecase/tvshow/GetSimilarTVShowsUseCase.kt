package com.palmdev.findamovie.domain.usecase.tvshow

import com.palmdev.findamovie.DEFAULT_LANGUAGE
import com.palmdev.findamovie.domain.entity.tvshow.TVShowsPage
import com.palmdev.findamovie.domain.repository.TVShowRepository

class GetSimilarTVShowsUseCase(private val tvShowRepository: TVShowRepository) {

    suspend fun invoke(
        movieID: Int,
        language: String = DEFAULT_LANGUAGE
    ): TVShowsPage? {
        return tvShowRepository.getSimilarTVShows(movieID, language)
    }

}