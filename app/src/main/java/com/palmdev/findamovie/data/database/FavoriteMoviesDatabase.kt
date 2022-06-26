package com.palmdev.findamovie.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.palmdev.findamovie.data.entity.MovieEntity

@Database(entities = [MovieEntity::class], version = 1)
abstract class FavoriteMoviesDatabase : RoomDatabase() {

    abstract fun getMovieDao(): FavoriteMoviesDao

}