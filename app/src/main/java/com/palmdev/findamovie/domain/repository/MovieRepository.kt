package com.palmdev.findamovie.domain.repository

import com.palmdev.findamovie.domain.entity.MoviesPage
import retrofit2.Response

interface MovieRepository {
    suspend fun getUpcomingMovies(): MoviesPage?
}