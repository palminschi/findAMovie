package com.palmdev.findamovie

import com.palmdev.findamovie.presentation.MainActivity
import java.util.*

lateinit var MAIN: MainActivity
const val BASE_URL = "https://api.themoviedb.org/"
const val API_KEY = "64d3b8502623cc4de48ed6b841850a04"
const val MOVIE_IMAGE_PATH = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2"
const val MOVIE_TABLE = "movie_table" // for ROOM
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