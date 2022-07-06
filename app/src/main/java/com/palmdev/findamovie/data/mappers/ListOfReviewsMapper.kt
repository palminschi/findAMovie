package com.palmdev.findamovie.data.mappers

import com.palmdev.findamovie.data.entity.ListOfReviewsDto
import com.palmdev.findamovie.domain.entity.ListOfReviews

class ListOfReviewsMapper : Mapper<ListOfReviewsDto, ListOfReviews> {
    override fun mapToDomain(dataModel: ListOfReviewsDto): ListOfReviews {
        return ListOfReviews(
            id = dataModel.id,
            page = dataModel.page,
            results = dataModel.results.map {
                ReviewMapper().mapToDomain(it)
            },
            total_pages = dataModel.total_pages,
            total_results = dataModel.total_results
        )
    }

    override fun mapToData(domainModel: ListOfReviews): ListOfReviewsDto {
        return ListOfReviewsDto(
            id = domainModel.id,
            page = domainModel.page,
            results = domainModel.results.map {
                ReviewMapper().mapToData(it)
            },
            total_pages = domainModel.total_pages,
            total_results = domainModel.total_results
        )
    }
}