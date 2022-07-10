package com.palmdev.findamovie.data.mappers

import com.palmdev.findamovie.data.entity.GenreDto
import com.palmdev.findamovie.data.entity.movie.MovieDetailsDto
import com.palmdev.findamovie.data.entity.ProductionCountryDto
import com.palmdev.findamovie.domain.entity.Genre
import com.palmdev.findamovie.domain.entity.movie.MovieDetails
import com.palmdev.findamovie.domain.entity.ProductionCountry

class MovieDetailsMapper : Mapper<MovieDetailsDto, MovieDetails> {

    override fun mapToDomain(dataModel: MovieDetailsDto): MovieDetails {
        return MovieDetails(
            adult = dataModel.adult,
            backdrop_path = dataModel.backdrop_path,
            budget = dataModel.budget,
            genres = dataModel.genre?.map {
                Genre(id = it.id, name = it.name)
            },
            homepage = dataModel.homepage,
            id = dataModel.id,
            imdb_id = dataModel.imdb_id,
            original_language = dataModel.original_language,
            original_title = dataModel.original_title,
            overview = dataModel.overview,
            popularity = dataModel.popularity,
            poster_path = dataModel.poster_path,
            production_countries = dataModel.production_countries.map {
                ProductionCountry(iso_3166_1 = it.iso_3166_1, name = it.name)
            },
            release_date = dataModel.release_date,
            revenue = dataModel.revenue,
            runtime = dataModel.runtime,
            status = dataModel.status,
            tagline = dataModel.tagline,
            title = dataModel.title,
            video = dataModel.video,
            vote_count = dataModel.vote_count,
            vote_average = dataModel.vote_average
        )
    }

    override fun mapToData(domainModel: MovieDetails): MovieDetailsDto {
        return MovieDetailsDto(
            adult = domainModel.adult,
            backdrop_path = domainModel.backdrop_path,
            budget = domainModel.budget,
            genre = domainModel.genres?.map {
                GenreDto(id = it.id, name = it.name)
            },
            homepage = domainModel.homepage,
            id = domainModel.id,
            imdb_id = domainModel.imdb_id,
            original_language = domainModel.original_language,
            original_title = domainModel.original_title,
            overview = domainModel.overview,
            popularity = domainModel.popularity,
            poster_path = domainModel.poster_path,
            production_countries = domainModel.production_countries.map {
                ProductionCountryDto(iso_3166_1 = it.iso_3166_1, name = it.name)
            },
            release_date = domainModel.release_date,
            revenue = domainModel.revenue,
            runtime = domainModel.runtime,
            status = domainModel.status,
            tagline = domainModel.tagline,
            title = domainModel.title,
            video = domainModel.video,
            vote_count = domainModel.vote_count,
            vote_average = domainModel.vote_average
        )
    }
}