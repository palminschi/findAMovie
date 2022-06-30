package com.palmdev.findamovie.data.mappers

import com.palmdev.findamovie.data.entity.ReviewDto
import com.palmdev.findamovie.domain.entity.Review

class ReviewMapper : Mapper<ReviewDto, Review> {
    override fun mapToDomain(dataModel: ReviewDto): Review {
        return Review(
            author = dataModel.author,
            content = dataModel.content,
            created_at = dataModel.created_at,
            id = dataModel.id,
            updated_at = dataModel.updated_at,
            url = dataModel.url
        )
    }

    override fun mapToData(domainModel: Review): ReviewDto {
        return ReviewDto(
            author = domainModel.author,
            content = domainModel.content,
            created_at = domainModel.created_at,
            id = domainModel.id,
            updated_at = domainModel.updated_at,
            url = domainModel.url
        )
    }
}