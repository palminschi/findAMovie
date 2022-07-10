package com.palmdev.findamovie.data.mappers

import com.palmdev.findamovie.domain.entity.movie.Movie
import com.palmdev.findamovie.domain.entity.search.SearchResult
import com.palmdev.findamovie.domain.entity.tvshow.TVShow

class DivideSearchResult {

    fun getMovie(result: SearchResult): Movie {
        return Movie(
            id = result.id,
            adult = result.adult!!,
            backdrop_path = result.backdrop_path,
            original_language = result.original_language!!,
            original_title = result.original_title!!,
            overview = result.overview,
            popularity = result.popularity!!,
            poster_path = result.poster_path,
            release_date = result.release_date!!,
            title = result.title!!,
            video = result.video!!,
            vote_count = result.vote_count!!,
            vote_average = result.vote_average!!
        )
    }

    fun getTVShow(result: SearchResult): TVShow {
        return TVShow(
            backdrop_path = result.backdrop_path,
            first_air_date = result.first_air_date,
            id = result.id,
            name = result.name!!,
            original_language = result.original_language!!,
            original_name = result.original_name!!,
            overview = result.overview!!,
            popularity = result.popularity!!,
            poster_path = result.poster_path,
            vote_average = result.vote_average!!,
            vote_count = result.vote_count!!
        )
    }

    fun getPersons() {
        // TODO Persons
    }
}