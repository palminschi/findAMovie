package com.palmdev.findamovie.data.entity.tvshow

data class TVShowsPageDto(
    val page: Int,
    val results: List<TVShowDto>,
    val total_pages: Int,
    val total_results: Int
)