package com.palmdev.findamovie.domain.entity.movie

import com.palmdev.findamovie.domain.entity.movie.Movie

data class MoviesPage(
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)