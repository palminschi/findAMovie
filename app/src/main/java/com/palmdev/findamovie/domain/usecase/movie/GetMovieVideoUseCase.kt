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

        val video: Video? = videos?.find {
            it.iso_639_1 == language
        }

        return video
    }

}