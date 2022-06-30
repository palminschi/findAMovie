package com.palmdev.findamovie.domain.repository

import com.palmdev.findamovie.domain.entity.search.Search

interface SearchRepository {

    suspend fun search(
        query: String,
        language: String,
        page: Int,
        include_adult: Boolean
    ): Search?

}