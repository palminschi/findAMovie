package com.palmdev.findamovie.data.retrofit.api

import com.palmdev.findamovie.API_KEY
import com.palmdev.findamovie.models.MoviesPage
import com.palmdev.findamovie.userLanguage
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("3/movie/upcoming?api_key=$API_KEY&language=$userLanguage")
    suspend fun getUpcomingMovies(): Response<MoviesPage>
}