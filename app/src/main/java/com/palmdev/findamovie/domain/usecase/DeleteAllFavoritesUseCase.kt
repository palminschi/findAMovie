package com.palmdev.findamovie.domain.usecase

import com.palmdev.findamovie.domain.repository.FavoritesRepository

class DeleteAllFavoritesUseCase(private val favoritesRepository: FavoritesRepository) {

    suspend fun invoke(){
        favoritesRepository.deleteAll()
    }

}