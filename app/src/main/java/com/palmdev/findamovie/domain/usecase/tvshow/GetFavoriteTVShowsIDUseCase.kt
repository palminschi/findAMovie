package com.palmdev.findamovie.domain.usecase.tvshow

import com.palmdev.findamovie.domain.repository.FavoritesRepository

class GetFavoriteTVShowsIDUseCase(private val favoritesRepository: FavoritesRepository) {

    fun invoke(): List<String> {
        return favoritesRepository.favoriteTVShowsID
    }

}