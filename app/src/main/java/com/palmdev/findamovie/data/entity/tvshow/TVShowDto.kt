package com.palmdev.findamovie.data.entity.tvshow

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.palmdev.findamovie.TV_SHOW_TABLE

@Entity(tableName = TV_SHOW_TABLE)
data class TVShowDto(
    @PrimaryKey(autoGenerate = true)
    val database_id: Int? = null,
    val backdrop_path: String?,
    val first_air_date: String,
    val id: Int,
    val name: String,
    val original_language: String,
    val original_name: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String?,
    val vote_average: Double,
    val vote_count: Int
)