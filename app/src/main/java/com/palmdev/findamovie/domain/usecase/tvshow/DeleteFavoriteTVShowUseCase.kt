package com.palmdev.findamovie.domain.usecase.tvshow

import com.palmdev.findamovie.domain.repository.FavoritesRepository

class DeleteFavoriteTVShowUseCase(private val favoritesRepository: FavoritesRepository) {

    suspend fun invoke(tvID: Int){
        favoritesRepository.deleteTVShow(tvID)
    }

}