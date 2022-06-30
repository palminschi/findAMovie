package com.palmdev.findamovie.data.database

import androidx.room.*
import com.palmdev.findamovie.data.entity.tvshow.TVShowDto
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteTVShowsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveFavoriteTVShow(tvShowDto: TVShowDto)

    @Query("DELETE FROM tv_show_table WHERE `id` = :id")
    fun deleteFavoriteTVShow(id: Int)

    @Query("DELETE FROM tv_show_table")
    fun deleteAll()

    @Query("SELECT * FROM tv_show_table")
    fun getFavoriteTVShows(): Flow<List<TVShowDto>>

}