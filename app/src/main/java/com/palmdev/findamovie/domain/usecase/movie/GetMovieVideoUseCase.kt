package com.palmdev.findamovie.domain.usecase.movie

import com.palmdev.findamovie.DEFAULT_LANGUAGE
import com.palmdev.findamovie.domain.entity.VideoInfo
import com.palmdev.findamovie.domain.repository.MovieRepository

class GetMovieVideoUseCase(private val movieRepository: MovieRepository) {

    suspend fun invoke(
        movieID: Int,
        language: String = DEFAULT_LANGUAGE
    ): VideoInfo? {

        var videos = movieRepository.getMovieVideos(movieID, language)?.results

        var videoInfo: VideoInfo? = videos?.find {
            it.iso_639_1 == language && it.site == "YouTube"
        }
        // if there's no video in user language
        if (videoInfo == null) {
            videos = movieRepository.getMovieVideos(movieID, DEFAULT_LANGUAGE)?.results
            videoInfo = videos?.find {
                it.iso_639_1 == DEFAULT_LANGUAGE && it.site == "YouTube"
            }
        }

        return videoInfo
    }

}