package com.palmdev.findamovie.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.palmdev.findamovie.data.entity.MovieEntity

@Database(entities = [MovieEntity::class], version = 1, exportSchema = false)
abstract class FavoriteMoviesDatabase : RoomDatabase() {

    abstract fun favoriteMoviesDao(): FavoriteMoviesDao

}