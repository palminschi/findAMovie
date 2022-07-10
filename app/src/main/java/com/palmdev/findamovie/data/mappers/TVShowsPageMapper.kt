package com.palmdev.findamovie.data.mappers

import com.palmdev.findamovie.data.entity.tvshow.TVShowsPageDto
import com.palmdev.findamovie.domain.entity.tvshow.TVShowsPage

class TVShowsPageMapper: Mapper<TVShowsPageDto, TVShowsPage> {
    override fun mapToDomain(dataModel: TVShowsPageDto): TVShowsPage {
        return TVShowsPage(
            page = dataModel.page,
            results = dataModel.results.map {
                TVShowMapper().mapToDomain(it)
            },
            total_pages = dataModel.total_pages,
            total_results = dataModel.total_results
        )
    }

    override fun mapToData(domainModel: TVShowsPage): TVShowsPageDto {
        return TVShowsPageDto(
            page = domainModel.page,
            results = domainModel.results.map {
                TVShowMapper().mapToData(it)
            },
            total_pages = domainModel.total_pages,
            total_results = domainModel.total_results
        )
    }
}