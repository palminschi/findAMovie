package com.palmdev.findamovie.data.mappers

import com.palmdev.findamovie.data.entity.search.MovieOrTVShowDto
import com.palmdev.findamovie.domain.entity.search.MovieOrTVShow

class MovieOrTVShowMapper: Mapper<MovieOrTVShowDto, MovieOrTVShow> {
    override fun mapToDomain(dataModel: MovieOrTVShowDto): MovieOrTVShow {
        return MovieOrTVShow(
            adult = dataModel.adult,
            backdrop_path = dataModel.backdrop_path,
            first_air_date = dataModel.first_air_date,
            id = dataModel.id,
            media_type = dataModel.media_type,
            name = dataModel.name,
            original_language = dataModel.original_language,
            original_name = dataModel.original_name,
            original_title = dataModel.original_title,
            overview = dataModel.overview,
            popularity = dataModel.popularity,
            poster_path = dataModel.poster_path,
            release_date = dataModel.release_date,
            title = dataModel.title,
            video = dataModel.video,
            vote_average = dataModel.vote_average,
            vote_count = dataModel.vote_count
        )
    }

    override fun mapToData(domainModel: MovieOrTVShow): MovieOrTVShowDto {
        return MovieOrTVShowDto(
            adult = domainModel.adult,
            backdrop_path = domainModel.backdrop_path,
            first_air_date = domainModel.first_air_date,
            id = domainModel.id,
            media_type = domainModel.media_type,
            name = domainModel.name,
            original_language = domainModel.original_language,
            original_name = domainModel.original_name,
            original_title = domainModel.original_title,
            overview = domainModel.overview,
            popularity = domainModel.popularity,
            poster_path = domainModel.poster_path,
            release_date = domainModel.release_date,
            title = domainModel.title,
            video = domainModel.video,
            vote_average = domainModel.vote_average,
            vote_count = domainModel.vote_count
        )
    }
}