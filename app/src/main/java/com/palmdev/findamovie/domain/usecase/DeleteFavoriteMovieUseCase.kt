package com.palmdev.findamovie.domain.usecase

import com.palmdev.findamovie.domain.repository.FavoritesRepository

class DeleteFavoriteMovieUseCase(private val favoritesRepository: FavoritesRepository) {

    suspend fun invoke(movieID: Int){
        favoritesRepository.deleteMovie(movieID)
    }

}