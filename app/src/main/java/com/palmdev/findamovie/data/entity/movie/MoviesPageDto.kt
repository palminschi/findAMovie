package com.palmdev.findamovie.data.entity.movie

data class MoviesPageDto(
    val page: Int,
    val results: List<MovieDto>,
    val total_pages: Int,
    val total_results: Int
)