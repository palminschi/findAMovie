package com.palmdev.findamovie.data.entity.movie

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.palmdev.findamovie.MOVIE_TABLE

@Entity(tableName = MOVIE_TABLE)
data class MovieDto(
    @PrimaryKey(autoGenerate = true)
    val database_id: Int? = null,
    val id: Int,
    val adult: Boolean,
    val backdrop_path: String?,
    val original_language: String,
    val original_title: String,
    val overview: String?,
    val popularity: Double,
    val poster_path: String?,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)