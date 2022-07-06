package com.palmdev.findamovie

import com.palmdev.findamovie.presentation.MainActivity
import java.util.*

lateinit var MAIN: MainActivity
const val BASE_URL = "https://api.themoviedb.org/3/"
const val API_KEY = "64d3b8502623cc4de48ed6b841850a04"
const val IMAGE_URL = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2"
const val YOUTUBE_URL = "https://www.youtube.com/watch?v="
const val YOUTUBE_API_KEY = "AIzaSyA9smspF_cvDeCq34Lto4aALn0WllBkAtw"
const val MOVIE_TABLE = "movie_table"
const val TV_SHOW_TABLE = "tv_show_table"
const val DATABASE_NAME = "favorite_movies_database"
const val DEFAULT_LANGUAGE = "en"

object Const {
    private var userLanguage = DEFAULT_LANGUAGE
    fun setUserLanguage(language: String) {
        userLanguage = language
    }

    fun getUserLanguage(): String {
        return userLanguage
    }
}