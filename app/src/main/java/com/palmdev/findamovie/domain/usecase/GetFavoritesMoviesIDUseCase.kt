package com.palmdev.findamovie.domain.usecase

import com.palmdev.findamovie.domain.repository.FavoriteMoviesRepository

class GetFavoritesMoviesIDUseCase(private val favoriteMoviesRepository: FavoriteMoviesRepository) {

    fun invoke(): List<String> {
        return favoriteMoviesRepository.getMoviesID()
    }

}