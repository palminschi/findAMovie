package com.palmdev.findamovie.data.repository

import com.palmdev.findamovie.data.mappers.SearchMapper
import com.palmdev.findamovie.data.network.ApiService
import com.palmdev.findamovie.domain.entity.search.Search
import com.palmdev.findamovie.domain.repository.SearchRepository

class SearchRepositoryImpl(private val apiService: ApiService) : SearchRepository {

    private val searchMapper = SearchMapper()

    override suspend fun search(
        query: String,
        language: String,
        page: Int,
        include_adult: Boolean
    ): Search? {
        return apiService.search(query, language, page, include_adult).body()?.let {
            searchMapper.mapToDomain(it)
        }
    }

}