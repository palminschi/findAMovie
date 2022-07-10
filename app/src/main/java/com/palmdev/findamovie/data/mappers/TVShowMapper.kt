package com.palmdev.findamovie.data.mappers

import com.palmdev.findamovie.data.entity.tvshow.TVShowDto
import com.palmdev.findamovie.domain.entity.tvshow.TVShow

class TVShowMapper: Mapper<TVShowDto, TVShow> {
    override fun mapToDomain(dataModel: TVShowDto): TVShow {
        return TVShow(
            backdrop_path = dataModel.backdrop_path,
            first_air_date = dataModel.first_air_date,
            name = dataModel.name,
            id = dataModel.id,
            original_name = dataModel.original_name,
            original_language = dataModel.original_language,
            overview = dataModel.overview,
            popularity = dataModel.popularity,
            poster_path = dataModel.poster_path,
            vote_count = dataModel.vote_count,
            vote_average = dataModel.vote_average
        )
    }

    override fun mapToData(domainModel: TVShow): TVShowDto {
        return TVShowDto(
            backdrop_path = domainModel.backdrop_path,
            first_air_date = domainModel.first_air_date,
            name = domainModel.name,
            id = domainModel.id,
            original_name = domainModel.original_name,
            original_language = domainModel.original_language,
            overview = domainModel.overview,
            popularity = domainModel.popularity,
            poster_path = domainModel.poster_path,
            vote_count = domainModel.vote_count,
            vote_average = domainModel.vote_average
        )
    }
}