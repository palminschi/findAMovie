package com.palmdev.findamovie.data.mappers

import com.palmdev.findamovie.data.entity.movie.MoviesPageDto
import com.palmdev.findamovie.domain.entity.movie.MoviesPage

class MoviesPageMapper: Mapper<MoviesPageDto, MoviesPage> {
    override fun mapToDomain(dataModel: MoviesPageDto): MoviesPage {
        return MoviesPage(
            page = dataModel.page,
            results = dataModel.results.map { MovieMapper().mapToDomain(it) },
            total_pages = dataModel.total_pages,
            total_results = dataModel.total_results
        )
    }

    override fun mapToData(domainModel: MoviesPage): MoviesPageDto {
        return MoviesPageDto(
            page = domainModel.page,
            results = domainModel.results.map { MovieMapper().mapToData(it) },
            total_pages = domainModel.total_pages,
            total_results = domainModel.total_results
        )
    }
}