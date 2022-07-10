package com.palmdev.findamovie.data.storage

import android.content.Context

/**
Saving ID of Favorite Movies as an Array to Shared Preferences
 **/

private const val FAVORITE_MOVIES_ID = "FAVORITE_MOVIES_ID"

class FavoriteMoviesIDStorage(context: Context) {

    private val moviesSharedPrefs =
        context.getSharedPreferences(FAVORITE_MOVIES_ID, Context.MODE_PRIVATE)

    fun addFavoriteMovieID(movieID: String) {
        val key = moviesSharedPrefs.all.size + 1
        moviesSharedPrefs.edit().putString(key.toString(), movieID).apply()
    }

    fun getFavoriteMoviesID(): List<String> {
        return moviesSharedPrefs.all.map {
            it.value.toString()
        }
    }

    fun deleteFavoriteMovieID(movieID: String) {
        var key = "0"

        moviesSharedPrefs.all.map {
            if (it.value == movieID) key = it.key
        }

        moviesSharedPrefs.edit().remove(key).apply()
    }

    fun deleteAll() {
        moviesSharedPrefs.all.forEach {
            moviesSharedPrefs.edit().remove( it.key ).apply()
        }
    }

}