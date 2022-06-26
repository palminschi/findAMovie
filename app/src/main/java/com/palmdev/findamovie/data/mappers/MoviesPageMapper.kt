package com.palmdev.findamovie.data.mappers

import com.palmdev.findamovie.data.entity.MoviesPageEntity
import com.palmdev.findamovie.domain.entity.Movie
import com.palmdev.findamovie.domain.entity.MoviesPage

class MoviesPageMapper {
    fun mapToDomain(moviesPageEntity: MoviesPageEntity): MoviesPage {
        return MoviesPage(
            page = moviesPageEntity.page,
            results = moviesPageEntity.results.map { MovieMapper().mapToDomain(it) },
            total_pages = moviesPageEntity.total_pages,
            total_results = moviesPageEntity.total_results
        )
    }

    fun mapToData(moviesPage: MoviesPage): MoviesPageEntity {
        return MoviesPageEntity(
            page = moviesPage.page,
            results = moviesPage.results.map { MovieMapper().mapToData(it) },
            total_pages = moviesPage.total_pages,
            total_results = moviesPage.total_results
        )
    }
}