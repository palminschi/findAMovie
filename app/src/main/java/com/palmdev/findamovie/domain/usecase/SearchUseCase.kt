package com.palmdev.findamovie.domain.usecase

import com.palmdev.findamovie.DEFAULT_LANGUAGE
import com.palmdev.findamovie.domain.entity.search.Search
import com.palmdev.findamovie.domain.repository.MovieRepository
import com.palmdev.findamovie.domain.repository.SearchRepository

class SearchUseCase(private val searchRepository: SearchRepository) {

    suspend fun invoke(
        query: String,
        language: String = DEFAULT_LANGUAGE,
        page: Int = 1,
        include_adult: Boolean = false
    ): Search? {
        return searchRepository.search(query, language, page, include_adult)
    }
}