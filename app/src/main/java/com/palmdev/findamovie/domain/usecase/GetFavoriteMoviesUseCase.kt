package com.palmdev.findamovie.domain.usecase

import com.palmdev.findamovie.domain.entity.movie.Movie
import com.palmdev.findamovie.domain.repository.FavoritesRepository
import kotlinx.coroutines.flow.Flow

class GetFavoriteMoviesUseCase(private val favoritesRepository: FavoritesRepository) {

    fun invoke(): Flow<List<Movie>> {
        return favoritesRepository.favoriteMovies
    }

}