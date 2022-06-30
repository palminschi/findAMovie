package com.palmdev.findamovie.domain.entity.search

data class Search(
    val page: Int,
    val results: List<SearchResult>,
    val total_pages: Int,
    val total_results: Int
)