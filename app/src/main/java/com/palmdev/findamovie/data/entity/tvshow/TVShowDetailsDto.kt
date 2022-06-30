package com.palmdev.findamovie.data.entity.tvshow

import com.palmdev.findamovie.data.entity.GenreDto
import com.palmdev.findamovie.data.entity.ProductionCountryDto

data class TVShowDetailsDto(
    val backdrop_path: String?,
    val episode_run_time: List<Int>,
    val first_air_date: String,
    val genres: List<GenreDto>,
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
    val production_countries: List<ProductionCountryDto>,
    val seasons: List<SeasonDto>,
    val status: String,
    val tagline: String,
    val type: String,
    val vote_average: Double,
    val vote_count: Int
)