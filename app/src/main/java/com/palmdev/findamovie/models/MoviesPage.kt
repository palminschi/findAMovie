package com.palmdev.findamovie.models

data class MoviesPage(
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)