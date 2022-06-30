package com.palmdev.findamovie.data.network

import com.palmdev.findamovie.API_KEY
import com.palmdev.findamovie.data.entity.ListOfReviewsDto
import com.palmdev.findamovie.data.entity.ListOfVideosDto
import com.palmdev.findamovie.data.entity.movie.MovieDetailsDto
import com.palmdev.findamovie.data.entity.movie.MoviesPageDto
import com.palmdev.findamovie.data.entity.search.SearchDto
import com.palmdev.findamovie.data.entity.tvshow.TVShowDetailsDto
import com.palmdev.findamovie.data.entity.tvshow.TVShowsPageDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    // Movies:
    @GET("movie/upcoming?api_key=$API_KEY")
    suspend fun getUpcomingMovies(
        @Query("language") language: String,
        @Query("page") page: Int
    ): Response<MoviesPageDto>

    @GET("movie/top_rated?api_key=$API_KEY")
    suspend fun getTopRatedMovies(
        @Query("language") language: String,
        @Query("page") page: Int
    ): Response<MoviesPageDto>

    @GET("movie/popular?api_key=$API_KEY")
    suspend fun getPopularMovies(
        @Query("language") language: String,
        @Query("page") page: Int
    ): Response<MoviesPageDto>

    @GET("movie/now_playing?api_key=$API_KEY")
    suspend fun getNowPlayingMovies(
        @Query("language") language: String,
        @Query("page") page: Int
    ): Response<MoviesPageDto>

    @GET("movie/{movie_id}/similar?api_key=$API_KEY")
    suspend fun getSimilarMovies(
        @Path("movie_id") movieID: Int,
        @Query("language") language: String
    ): Response<MoviesPageDto>

    @GET("movie/{movie_id}?api_key=$API_KEY")
    suspend fun getMovieDetails(
        @Path("movie_id") movieID: Int,
        @Query("language") language: String
    ): Response<MovieDetailsDto>

    @GET("movie/{movie_id}/reviews?api_key=$API_KEY")
    suspend fun getMovieVideos(
        @Path("movie_id") movieID: Int,
        @Query("language") language: String
    ): Response<ListOfVideosDto>

    @GET("movie/{movie_id}/videos?api_key=$API_KEY")
    suspend fun getMovieReviews(
        @Path("movie_id") movieID: Int,
        @Query("language") language: String
    ): Response<ListOfReviewsDto>

    // TV Shows:
    @GET("tv/popular?api_key=$API_KEY")
    suspend fun getPopularTVShows(
        @Query("language") language: String,
        @Query("page") page: Int
    ): Response<TVShowsPageDto>

    @GET("tv/top_rated?api_key=$API_KEY")
    suspend fun getTopRatedTVShows(
        @Query("language") language: String,
        @Query("page") page: Int
    ): Response<TVShowsPageDto>

    @GET("tv/{tv_id}/similar?api_key=$API_KEY")
    suspend fun getSimilarTVShows(
        @Path("tv_id") tvID: Int,
        @Query("language") language: String
    ): Response<TVShowsPageDto>

    @GET("tv/{tv_id}?api_key=$API_KEY")
    suspend fun getTVShowDetails(
        @Path("tv_id") tvID: Int,
        @Query("language") language: String
    ): Response<TVShowDetailsDto>

    @GET("tv/{tv_id}/videos?api_key=$API_KEY")
    suspend fun getTVShowVideos(
        @Path("tv_id") tvID: Int,
        @Query("language") language: String
    ): Response<ListOfVideosDto>

    @GET("tv/{tv_id}/reviews?api_key=$API_KEY")
    suspend fun getTVShowReviews(
        @Path("tv_id") tvID: Int,
        @Query("language") language: String
    ): Response<ListOfReviewsDto>

    // Search
    @GET("search/multi?api_key=$API_KEY")
    suspend fun search(
        @Query("query") query: String,
        @Query("language") language: String,
        @Query("page") page: Int,
        @Query("include_adult") include_adult: Boolean,
    ): Response<SearchDto>
}
