package com.palmdev.findamovie.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.palmdev.findamovie.data.entity.MovieEntity

@Dao
interface FavoriteMoviesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovie(movieEntity: MovieEntity)

    @Delete
    suspend fun deleteMovie(movieEntity: MovieEntity)

    @Query("SELECT * FROM movie_table")
    fun getFavoriteMovies(): LiveData<List<MovieEntity>>
}