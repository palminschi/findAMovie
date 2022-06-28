package com.palmdev.findamovie.domain.usecase

import androidx.lifecycle.LiveData
import com.palmdev.findamovie.domain.entity.Movie
import com.palmdev.findamovie.domain.repository.FavoriteMoviesRepository
import kotlinx.coroutines.flow.Flow

class GetFavoriteMoviesUseCase(private val favoriteMoviesRepository: FavoriteMoviesRepository) {

    fun invoke(): Flow<List<Movie>> {
        return favoriteMoviesRepository.favoriteMovies
    }

}