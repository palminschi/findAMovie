package com.palmdev.findamovie.domain.usecase

import com.palmdev.findamovie.domain.entity.Movie
import com.palmdev.findamovie.domain.repository.FavoriteMoviesRepository

class SaveFavoriteMovieUseCase(private val favoriteMoviesRepository: FavoriteMoviesRepository) {

    suspend fun invoke(movie: Movie) {
        favoriteMoviesRepository.saveMovie(movie)
    }

}