package com.palmdev.findamovie.data.entity

data class MoviesPageEntity(
    val page: Int,
    val results: List<MovieEntity>,
    val total_pages: Int,
    val total_results: Int
)