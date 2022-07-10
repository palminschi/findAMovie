package com.palmdev.findamovie.domain.entity.tvshow

data class TVShowsPage(
    val page: Int,
    val results: List<TVShow>,
    val total_pages: Int,
    val total_results: Int
)