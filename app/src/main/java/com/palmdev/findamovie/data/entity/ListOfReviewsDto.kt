package com.palmdev.findamovie.data.entity

data class ListOfReviewsDto(
    val id: Int,
    val page: Int,
    val results: List<ReviewDto>,
    val total_pages: Int,
    val total_results: Int
)