package com.palmdev.findamovie.data.entity.movie

import com.palmdev.findamovie.data.entity.GenreDto
import com.palmdev.findamovie.data.entity.ProductionCountryDto

data class MovieDetailsDto(
    val adult: Boolean,
    val backdrop_path: String?,
    val budget: Int,
    val genre: List<GenreDto>?,
    val homepage: String?,
    val id: Int,
    val imdb_id: String?,
    val original_language: String,
    val original_title: String,
    val overview: String?,
    val popularity: Double,
    val poster_path: String?,
    val production_countries: List<ProductionCountryDto>,
    val release_date: String,
    val revenue: Int,
    val runtime: Int?,
    val status: String,
    val tagline: String?,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)