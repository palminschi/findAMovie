package com.palmdev.findamovie.data.mappers

import com.palmdev.findamovie.data.entity.GenreDto
import com.palmdev.findamovie.data.entity.ProductionCountryDto
import com.palmdev.findamovie.data.entity.tvshow.TVShowDetailsDto
import com.palmdev.findamovie.domain.entity.Genre
import com.palmdev.findamovie.domain.entity.ProductionCountry
import com.palmdev.findamovie.domain.entity.tvshow.TVShowDetails

class TVShowDetailsMapper: Mapper<TVShowDetailsDto, TVShowDetails> {
    override fun mapToDomain(dataModel: TVShowDetailsDto): TVShowDetails {
        return TVShowDetails(
            backdrop_path = dataModel.backdrop_path,
            episode_run_time = dataModel.episode_run_time,
            first_air_date = dataModel.first_air_date,
            genres = dataModel.genres.map {
                Genre(id = it.id, name = it.name)
            },
            homepage = dataModel.homepage,
            id = dataModel.id,
            in_production = dataModel.in_production,
            last_air_date = dataModel.last_air_date,
            name = dataModel.name,
            next_episode_to_air = dataModel.next_episode_to_air,
            number_of_episodes = dataModel.number_of_episodes,
            number_of_seasons = dataModel.number_of_seasons,
            origin_country = dataModel.origin_country,
            original_language = dataModel.original_language,
            original_name = dataModel.original_name,
            overview = dataModel.overview,
            popularity = dataModel.popularity,
            poster_path = dataModel.poster_path,
            production_countries = dataModel.production_countries.map {
                ProductionCountry(iso_3166_1 = it.iso_3166_1, name = it.name)
            },
            seasons = dataModel.seasons.map {
                SeasonMapper().mapToDomain(it)
            },
            status = dataModel.status,
            tagline = dataModel.tagline,
            type = dataModel.type,
            vote_average = dataModel.vote_average,
            vote_count = dataModel.vote_count
        )
    }

    override fun mapToData(domainModel: TVShowDetails): TVShowDetailsDto {
        return TVShowDetailsDto(
            backdrop_path = domainModel.backdrop_path,
            episode_run_time = domainModel.episode_run_time,
            first_air_date = domainModel.first_air_date,
            genres = domainModel.genres.map {
                GenreDto(id = it.id, name = it.name)
            },
            homepage = domainModel.homepage,
            id = domainModel.id,
            in_production = domainModel.in_production,
            last_air_date = domainModel.last_air_date,
            name = domainModel.name,
            next_episode_to_air = domainModel.next_episode_to_air,
            number_of_episodes = domainModel.number_of_episodes,
            number_of_seasons = domainModel.number_of_seasons,
            origin_country = domainModel.origin_country,
            original_language = domainModel.original_language,
            original_name = domainModel.original_name,
            overview = domainModel.overview,
            popularity = domainModel.popularity,
            poster_path = domainModel.poster_path,
            production_countries = domainModel.production_countries.map {
                ProductionCountryDto(iso_3166_1 = it.iso_3166_1, name = it.name)
            },
            seasons = domainModel.seasons.map {
                SeasonMapper().mapToData(it)
            },
            status = domainModel.status,
            tagline = domainModel.tagline,
            type = domainModel.type,
            vote_average = domainModel.vote_average,
            vote_count = domainModel.vote_count
        )
    }
}