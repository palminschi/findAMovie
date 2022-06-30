package com.palmdev.findamovie.domain.usecase.tvshow

import com.palmdev.findamovie.domain.entity.movie.Movie
import com.palmdev.findamovie.domain.entity.tvshow.TVShow
import com.palmdev.findamovie.domain.repository.FavoritesRepository
import kotlinx.coroutines.flow.Flow

class GetFavoriteTVShowsUseCase(private val favoritesRepository: FavoritesRepository) {

    fun invoke(): Flow<List<TVShow>> {
        return favoritesRepository.favoriteTVShows
    }

}