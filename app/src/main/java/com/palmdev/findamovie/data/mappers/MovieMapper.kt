package com.palmdev.findamovie.data.mappers

import com.palmdev.findamovie.data.entity.MovieEntity
import com.palmdev.findamovie.domain.entity.Movie

class MovieMapper {

    fun mapToDomain(movieEntity: MovieEntity): Movie {
        return Movie(
            id = movieEntity.id,
            adult = movieEntity.adult,
            backdrop_path = movieEntity.backdrop_path,
            genre_ids = movieEntity.genre_ids,
            original_language = movieEntity.original_language,
            original_title = movieEntity.original_title,
            overview = movieEntity.overview,
            popularity = movieEntity.popularity,
            poster_path = movieEntity.poster_path,
            release_date = movieEntity.release_date,
            title = movieEntity.title,
            video = movieEntity.video,
            vote_average = movieEntity.vote_average,
            vote_count = movieEntity.vote_count
        )
    }

    fun mapToData(movie: Movie): MovieEntity {
        return MovieEntity(
            id = movie.id,
            adult = movie.adult,
            backdrop_path = movie.backdrop_path,
            genre_ids = movie.genre_ids,
            original_language = movie.original_language,
            original_title = movie.original_title,
            overview = movie.overview,
            popularity = movie.popularity,
            poster_path = movie.poster_path,
            release_date = movie.release_date,
            title = movie.title,
            video = movie.video,
            vote_average = movie.vote_average,
            vote_count = movie.vote_count
        )
    }

}