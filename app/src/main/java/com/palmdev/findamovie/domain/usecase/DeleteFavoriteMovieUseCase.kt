package com.palmdev.findamovie.domain.usecase

import com.palmdev.findamovie.domain.repository.FavoriteMoviesRepository

class DeleteFavoriteMovieUseCase(private val favoriteMoviesRepository: FavoriteMoviesRepository) {

    suspend fun invoke(movieID: Int){
        favoriteMoviesRepository.deleteMovie(movieID)
    }

}