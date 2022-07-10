package com.palmdev.findamovie.data.database

import androidx.room.*
import com.palmdev.findamovie.data.entity.movie.MovieDto
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteMoviesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveFavoriteMovie(movieDto: MovieDto)

    @Query("DELETE FROM movie_table WHERE `id` = :id")
    fun deleteFavoriteMovie(id: Int)

    @Query("DELETE FROM movie_table")
    fun deleteAll()

    @Query("SELECT * FROM movie_table")
    fun getFavoriteMovies(): Flow<List<MovieDto>>

}