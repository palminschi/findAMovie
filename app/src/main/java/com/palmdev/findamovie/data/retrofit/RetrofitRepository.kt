package com.palmdev.findamovie.data.retrofit

import com.palmdev.findamovie.data.retrofit.api.RetrofitInstance
import com.palmdev.findamovie.models.MoviesPage
import retrofit2.Response

class RetrofitRepository {

    suspend fun getUpcomingMovies(): Response<MoviesPage> {
        return RetrofitInstance.api.getUpcomingMovies()
    }
}