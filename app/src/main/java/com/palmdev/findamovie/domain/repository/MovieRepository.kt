package com.palmdev.findamovie.domain.repository

import com.palmdev.findamovie.domain.entity.MoviesPage

interface MovieRepository {

    suspend fun getUpcomingMovies(language: String, page: Int): MoviesPage?

}