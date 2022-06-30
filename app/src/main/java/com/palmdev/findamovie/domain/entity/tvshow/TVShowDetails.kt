package com.palmdev.findamovie.domain.entity.tvshow

import com.palmdev.findamovie.domain.entity.Genre
import com.palmdev.findamovie.domain.entity.ProductionCountry

data class TVShowDetails(
    val backdrop_path: String?,
    val episode_run_time: List<Int>,
    val first_air_date: String,
    val genres: List<Genre>,
    val homepage: String,
    val id: Int,
    val in_production: Boolean,
    val last_air_date: String,
    val name: String,
    val next_episode_to_air: Any, //TODO to delete maybe
    val number_of_episodes: Int,
    val number_of_seasons: Int,
    val origin_country: List<String>,
    val original_language: String,
    val original_name: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String?,
    val production_countries: List<ProductionCountry>,
    val seasons: List<Season>,
    val status: String,
    val tagline: String,
    val type: String,
    val vote_average: Double,
    val vote_count: Int
)