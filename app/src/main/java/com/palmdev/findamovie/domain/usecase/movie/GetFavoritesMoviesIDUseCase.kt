package com.palmdev.findamovie.domain.usecase.movie

import com.palmdev.findamovie.domain.repository.FavoritesRepository

class GetFavoritesMoviesIDUseCase(private val favoritesRepository: FavoritesRepository) {

    fun invoke(): List<String> {
        return favoritesRepository.favoriteMoviesID
    }

}