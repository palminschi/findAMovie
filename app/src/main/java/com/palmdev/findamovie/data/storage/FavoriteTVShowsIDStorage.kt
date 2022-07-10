package com.palmdev.findamovie.data.storage

import android.content.Context

/**
Saving ID of Favorite Movies as an Array to Shared Preferences
 **/

private const val FAVORITE_TV_SHOWS_ID = "FAVORITE_TV_SHOWS_ID"

class FavoriteTVShowsIDStorage(context: Context) {

    private val tvShowsSharedPrefs =
        context.getSharedPreferences(FAVORITE_TV_SHOWS_ID, Context.MODE_PRIVATE)

    fun addFavoriteTVShowID(tvID: String) {
        val key = tvShowsSharedPrefs.all.size + 1
        tvShowsSharedPrefs.edit().putString(key.toString(), tvID).apply()
    }

    fun getFavoriteTVShowsID(): List<String> {
        return tvShowsSharedPrefs.all.map {
            it.value.toString()
        }
    }

    fun deleteFavoriteTVShowID(tvID: String) {
        var key = "0"

        tvShowsSharedPrefs.all.map {
            if (it.value == tvID) key = it.key
        }

        tvShowsSharedPrefs.edit().remove(key).apply()
    }

    fun deleteAll() {
        tvShowsSharedPrefs.all.forEach {
            tvShowsSharedPrefs.edit().remove( it.key ).apply()
        }
    }

}