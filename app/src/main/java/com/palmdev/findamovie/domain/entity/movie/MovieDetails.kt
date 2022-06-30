package com.palmdev.findamovie.domain.entity.movie

import com.palmdev.findamovie.domain.entity.Genre
import com.palmdev.findamovie.domain.entity.ProductionCountry

data class MovieDetails(
    val adult: Boolean,
    val backdrop_path: String?,
    val budget: Int,
    val genres: List<Genre>,
    val homepage: String?,
    val id: Int,
    val imdb_id: String?,
    val original_language: String,
    val original_title: String,
    val overview: String?,
    val popularity: Double,
    val poster_path: String?,
    val production_countries: List<ProductionCountry>,
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