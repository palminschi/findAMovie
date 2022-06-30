package com.palmdev.findamovie.data.mappers

import com.palmdev.findamovie.data.entity.tvshow.SeasonDto
import com.palmdev.findamovie.domain.entity.tvshow.Season

class SeasonMapper : Mapper<SeasonDto, Season> {
    override fun mapToDomain(dataModel: SeasonDto): Season {
        return Season(
            air_date = dataModel.air_date,
            episode_count = dataModel.episode_count,
            id = dataModel.id,
            name = dataModel.name,
            overview = dataModel.overview,
            poster_path = dataModel.poster_path,
            season_number = dataModel.season_number
        )
    }

    override fun mapToData(domainModel: Season): SeasonDto {
        return SeasonDto(
            air_date = domainModel.air_date,
            episode_count = domainModel.episode_count,
            id = domainModel.id,
            name = domainModel.name,
            overview = domainModel.overview,
            poster_path = domainModel.poster_path,
            season_number = domainModel.season_number
        )
    }
}