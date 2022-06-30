package com.palmdev.findamovie.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.palmdev.findamovie.data.entity.movie.MovieDto
import com.palmdev.findamovie.data.entity.tvshow.TVShowDto

@Database(entities = [MovieDto::class, TVShowDto::class], version = 1, exportSchema = false)
abstract class FavoritesDatabase : RoomDatabase() {

    abstract fun favoriteMoviesDao(): FavoriteMoviesDao
    abstract fun favoriteTVShowsDao(): FavoriteTVShowsDao

}