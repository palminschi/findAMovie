package com.palmdev.findamovie.data.mappers

import com.palmdev.findamovie.data.entity.VideoDto
import com.palmdev.findamovie.domain.entity.VideoInfo

class VideoMapper: Mapper<VideoDto, VideoInfo> {
    override fun mapToDomain(dataModel: VideoDto): VideoInfo {
        return VideoInfo(
            id = dataModel.id,
            iso_3166_1 = dataModel.iso_3166_1,
            iso_639_1 = dataModel.iso_639_1,
            key = dataModel.key,
            name = dataModel.name,
            official = dataModel.official,
            published_at = dataModel.published_at,
            site = dataModel.site,
            size = dataModel.size,
            type = dataModel.type
        )
    }

    override fun mapToData(domainModel: VideoInfo): VideoDto {
        return VideoDto(
            id = domainModel.id,
            iso_3166_1 = domainModel.iso_3166_1,
            iso_639_1 = domainModel.iso_639_1,
            key = domainModel.key,
            name = domainModel.name,
            official = domainModel.official,
            published_at = domainModel.published_at,
            site = domainModel.site,
            size = domainModel.size,
            type = domainModel.type
        )
    }
}