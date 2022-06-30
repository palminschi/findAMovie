package com.palmdev.findamovie.data.mappers

import com.palmdev.findamovie.data.entity.search.SearchResultDto
import com.palmdev.findamovie.domain.entity.search.SearchResult

class SearchResultMapper: Mapper<SearchResultDto, SearchResult> {
    override fun mapToDomain(dataModel: SearchResultDto): SearchResult {
        return SearchResult(
            adult = dataModel.adult,
            backdrop_path = dataModel.backdrop_path,
            first_air_date = dataModel.first_air_date,
            genre_ids = dataModel.genre_ids,
            id = dataModel.id,
            known_for = dataModel.known_for?.map {
                MovieOrTVShowMapper().mapToDomain(it)
            },
            media_type = dataModel.media_type,
            name = dataModel.name,
            origin_country = dataModel.origin_country,
            original_language = dataModel.original_language,
            original_name = dataModel.original_name,
            original_title = dataModel.original_title,
            overview = dataModel.overview,
            popularity = dataModel.popularity,
            poster_path = dataModel.poster_path,
            profile_path = dataModel.profile_path,
            release_date = dataModel.release_date,
            title = dataModel.title,
            video = dataModel.video,
            vote_count = dataModel.vote_count,
            vote_average = dataModel.vote_average
        )
    }

    override fun mapToData(domainModel: SearchResult): SearchResultDto {
        return SearchResultDto(
            adult = domainModel.adult,
            backdrop_path = domainModel.backdrop_path,
            first_air_date = domainModel.first_air_date,
            genre_ids = domainModel.genre_ids,
            id = domainModel.id,
            known_for = domainModel.known_for?.map {
                MovieOrTVShowMapper().mapToData(it)
            },
            media_type = domainModel.media_type,
            name = domainModel.name,
            origin_country = domainModel.origin_country,
            original_language = domainModel.original_language,
            original_name = domainModel.original_name,
            original_title = domainModel.original_title,
            overview = domainModel.overview,
            popularity = domainModel.popularity,
            poster_path = domainModel.poster_path,
            profile_path = domainModel.profile_path,
            release_date = domainModel.release_date,
            title = domainModel.title,
            video = domainModel.video,
            vote_count = domainModel.vote_count,
            vote_average = domainModel.vote_average
        )
    }
}