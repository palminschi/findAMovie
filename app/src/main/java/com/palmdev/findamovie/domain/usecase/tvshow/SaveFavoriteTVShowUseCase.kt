package com.palmdev.findamovie.domain.usecase.tvshow

import com.palmdev.findamovie.domain.entity.tvshow.TVShow
import com.palmdev.findamovie.domain.repository.FavoritesRepository

class SaveFavoriteTVShowUseCase(private val favoritesRepository: FavoritesRepository) {

    suspend fun invoke(tvShow: TVShow) {
        favoritesRepository.saveTVShow(tvShow)
    }

}