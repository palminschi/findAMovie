package com.palmdev.findamovie.data.database

import androidx.room.*
import com.palmdev.findamovie.data.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteMoviesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveFavoriteMovie(movieEntity: MovieEntity)

    @Query("DELETE FROM movie_table WHERE `id` = :id")
    fun deleteFavoriteMovie(id: Int)

    @Query("SELECT * FROM movie_table")
    fun getFavoriteMovies(): Flow<List<MovieEntity>>

}