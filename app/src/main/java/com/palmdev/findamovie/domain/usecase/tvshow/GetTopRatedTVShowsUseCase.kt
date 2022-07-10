package com.palmdev.findamovie.domain.usecase.tvshow

import com.palmdev.findamovie.DEFAULT_LANGUAGE
import com.palmdev.findamovie.domain.entity.tvshow.TVShowsPage
import com.palmdev.findamovie.domain.repository.TVShowRepository

class GetTopRatedTVShowsUseCase(private val tvShowRepository: TVShowRepository) {

    suspend fun invoke(
        language: String = DEFAULT_LANGUAGE,
        page: Int = 1
    ): TVShowsPage? {
        return tvShowRepository.getTopRatedTVShows(language, page)
    }

}