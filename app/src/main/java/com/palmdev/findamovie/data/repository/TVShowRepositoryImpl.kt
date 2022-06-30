package com.palmdev.findamovie.data.repository

import com.palmdev.findamovie.data.mappers.ListOfReviewsMapper
import com.palmdev.findamovie.data.mappers.TVShowDetailsMapper
import com.palmdev.findamovie.data.mappers.TVShowsPageMapper
import com.palmdev.findamovie.data.mappers.VideoMapper
import com.palmdev.findamovie.data.network.ApiService
import com.palmdev.findamovie.domain.entity.ListOfReviews
import com.palmdev.findamovie.domain.entity.ListOfVideos
import com.palmdev.findamovie.domain.entity.tvshow.TVShowDetails
import com.palmdev.findamovie.domain.entity.tvshow.TVShowsPage
import com.palmdev.findamovie.domain.repository.TVShowRepository

class TVShowRepositoryImpl(private val apiService: ApiService) : TVShowRepository {

    private val tvShowsPageMapper = TVShowsPageMapper()
    private val tvShowDetailsMapper = TVShowDetailsMapper()
    private val videoMapper = VideoMapper()
    private val listOfReviewsMapper = ListOfReviewsMapper()


    override suspend fun getTopRatedTVShows(language: String, page: Int): TVShowsPage? {
        return apiService.getTopRatedTVShows(language, page).body()?.let {
            tvShowsPageMapper.mapToDomain(it)
        }
    }

    override suspend fun getPopularTVShows(language: String, page: Int): TVShowsPage? {
        return apiService.getPopularTVShows(language, page).body()?.let {
            tvShowsPageMapper.mapToDomain(it)
        }
    }

    override suspend fun getSimilarTVShows(tvID: Int, language: String): TVShowsPage? {
        return apiService.getSimilarTVShows(tvID, language).body()?.let {
            tvShowsPageMapper.mapToDomain(it)
        }
    }

    override suspend fun getTVShowDetails(tvID: Int, language: String): TVShowDetails? {
        return apiService.getTVShowDetails(tvID, language).body()?.let {
            tvShowDetailsMapper.mapToDomain(it)
        }
    }

    override suspend fun getTVShowVideos(tvID: Int, language: String): ListOfVideos? {
        return apiService.getTVShowVideos(tvID, language).body()?.let {
            ListOfVideos(
                id = it.id,
                results = it.results.map { video ->
                    videoMapper.mapToDomain(video)
                }
            )
        }
    }

    override suspend fun getTVShowReviews(tvID: Int, language: String): ListOfReviews? {
        return apiService.getTVShowReviews(tvID, language).body()?.let {
            listOfReviewsMapper.mapToDomain(it)
        }
    }

}