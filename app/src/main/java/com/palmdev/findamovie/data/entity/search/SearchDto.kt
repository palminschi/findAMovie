package com.palmdev.findamovie.data.entity.search

data class SearchDto(
    val page: Int,
    val results: List<SearchResultDto>,
    val total_pages: Int,
    val total_results: Int
)