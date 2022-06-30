package com.palmdev.findamovie.domain.usecase

import com.palmdev.findamovie.domain.entity.movie.Movie
import com.palmdev.findamovie.domain.repository.FavoritesRepository

class SaveFavoriteMovieUseCase(private val favoritesRepository: FavoritesRepository) {

    suspend fun invoke(movie: Movie) {
        favoritesRepository.saveMovie(movie)
    }

}