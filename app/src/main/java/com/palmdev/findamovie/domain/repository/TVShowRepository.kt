package com.palmdev.findamovie.domain.repository

import com.palmdev.findamovie.domain.entity.ListOfReviews
import com.palmdev.findamovie.domain.entity.ListOfVideos
import com.palmdev.findamovie.domain.entity.tvshow.TVShowDetails
import com.palmdev.findamovie.domain.entity.tvshow.TVShowsPage

interface TVShowRepository {

    suspend fun getTopRatedTVShows(language: String, page: Int): TVShowsPage?

    suspend fun getPopularTVShows(language: String, page: Int): TVShowsPage?

    suspend fun getSimilarTVShows(tvID: Int, language: String): TVShowsPage?

    suspend fun getTVShowDetails(tvID: Int, language: String): TVShowDetails?

    suspend fun getTVShowVideos(tvID: Int, language: String): ListOfVideos?

    suspend fun getTVShowReviews(tvID: Int, language: String): ListOfReviews?

}