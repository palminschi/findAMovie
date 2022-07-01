package com.palmdev.findamovie.domain.usecase.movie

import com.palmdev.findamovie.DEFAULT_LANGUAGE
import com.palmdev.findamovie.domain.entity.Video
import com.palmdev.findamovie.domain.repository.MovieRepository

class GetMovieVideoUseCase(private val movieRepository: MovieRepository) {

    suspend fun invoke(
        movieID: Int,
        language: String = DEFAULT_LANGUAGE
    ): Video? {

        val videos = movieRepository.getMovieVideos(movieID, language)?.results

        var video: Video? = videos?.find {
            it.iso_639_1 == language && it.site == "YouTube"
        }
        // if there's no video in user language
        if (video == null) {
            video = videos?.find {
                it.iso_639_1 == DEFAULT_LANGUAGE && it.site == "YouTube"
            }
        }

        return video
    }

}