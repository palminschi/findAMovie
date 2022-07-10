package com.palmdev.findamovie.data.mappers

import com.palmdev.findamovie.data.entity.movie.MovieDto
import com.palmdev.findamovie.domain.entity.movie.Movie

class MovieMapper : Mapper<MovieDto, Movie> {

    override fun mapToDomain(dataModel: MovieDto): Movie {
        return Movie(
            id = dataModel.id,
            adult = dataModel.adult,
            backdrop_path = dataModel.backdrop_path,
            original_language = dataModel.original_language,
            original_title = dataModel.original_title,
            overview = dataModel.overview,
            popularity = dataModel.popularity,
            poster_path = dataModel.poster_path,
            release_date = dataModel.release_date,
            title = dataModel.title,
            video = dataModel.video,
            vote_average = dataModel.vote_average,
            vote_count = dataModel.vote_count
        )
    }

    override fun mapToData(domainModel: Movie): MovieDto {
        return MovieDto(
            id = domainModel.id,
            adult = domainModel.adult,
            backdrop_path = domainModel.backdrop_path,
            original_language = domainModel.original_language,
            original_title = domainModel.original_title,
            overview = domainModel.overview,
            popularity = domainModel.popularity,
            poster_path = domainModel.poster_path,
            release_date = domainModel.release_date,
            title = domainModel.title,
            video = domainModel.video,
            vote_average = domainModel.vote_average,
            vote_count = domainModel.vote_count
        )
    }

}