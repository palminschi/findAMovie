package com.palmdev.findamovie.domain.usecase

import com.palmdev.findamovie.DEFAULT_LANGUAGE
import com.palmdev.findamovie.domain.entity.search.Search
import com.palmdev.findamovie.domain.repository.MovieRepository

class SearchUseCase(private val movieRepository: MovieRepository) {

    suspend fun invoke(
        query: String,
        language: String = DEFAULT_LANGUAGE,
        page: Int = 1,
        include_adult: Boolean = false
    ): Search? {
        return movieRepository.search(query, language, page, include_adult)
    }
}