package com.palmdev.findamovie.data.network

import com.palmdev.findamovie.API_KEY
import com.palmdev.findamovie.DEFAULT_LANGUAGE
import com.palmdev.findamovie.data.entity.MoviesPageEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("3/movie/upcoming?api_key=$API_KEY")
    suspend fun getUpcomingMovies(
        @Query("language") language: String,
        @Query("page") page: Int
    ): Response<MoviesPageEntity>
}