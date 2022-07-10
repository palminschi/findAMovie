package com.palmdev.findamovie.domain.entity.tvshow

import java.io.Serializable

data class TVShow(
    val database_id: Int? = null,
    val backdrop_path: String?,
    val first_air_date: String?,
    val id: Int,
    val name: String,
    val original_language: String,
    val original_name: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String?,
    val vote_average: Double,
    val vote_count: Int
): Serializable