package com.palmdev.findamovie.domain.usecase.tvshow

import com.palmdev.findamovie.DEFAULT_LANGUAGE
import com.palmdev.findamovie.domain.entity.Video
import com.palmdev.findamovie.domain.repository.TVShowRepository

class GetTVShowVideoUseCase(private val tvShowRepository: TVShowRepository) {

    suspend fun invoke(
        tvID: Int,
        language: String = DEFAULT_LANGUAGE
    ): Video? {

        val videos = tvShowRepository.getTVShowVideos(tvID, language)?.results

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