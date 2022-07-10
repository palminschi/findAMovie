package com.palmdev.findamovie.domain.entity

data class ListOfReviews(
    val id: Int,
    val page: Int,
    val results: List<Review>,
    val total_pages: Int,
    val total_results: Int
)