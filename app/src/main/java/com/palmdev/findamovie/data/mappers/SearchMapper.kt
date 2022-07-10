package com.palmdev.findamovie.data.mappers

import com.palmdev.findamovie.data.entity.search.SearchDto
import com.palmdev.findamovie.domain.entity.search.Search

class SearchMapper: Mapper<SearchDto, Search> {
    override fun mapToDomain(dataModel: SearchDto): Search {
        return Search(
            page = dataModel.page,
            results = dataModel.results.map {
                SearchResultMapper().mapToDomain(it)
            },
            total_results = dataModel.total_results,
            total_pages = dataModel.total_pages
        )
    }

    override fun mapToData(domainModel: Search): SearchDto {
        return SearchDto(
            page = domainModel.page,
            results = domainModel.results.map {
                SearchResultMapper().mapToData(it)
            },
            total_results = domainModel.total_results,
            total_pages = domainModel.total_pages
        )
    }
}