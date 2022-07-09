package com.palmdev.findamovie.presentation.screens.search

import androidx.lifecycle.*
import com.palmdev.findamovie.Const
import com.palmdev.findamovie.data.mappers.DivideSearchResult
import com.palmdev.findamovie.domain.entity.movie.Movie
import com.palmdev.findamovie.domain.entity.search.Search
import com.palmdev.findamovie.domain.entity.tvshow.TVShow
import com.palmdev.findamovie.domain.usecase.SearchUseCase
import kotlinx.coroutines.launch

class SearchViewModel(private val searchUseCase: SearchUseCase) : ViewModel() {

    private val _searchResult = MutableLiveData<Search>()
    val searchResult: LiveData<Search> = _searchResult
    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> = _movies
    private val _tvShows = MutableLiveData<List<TVShow>>()
    val tvShows: LiveData<List<TVShow>> = _tvShows

    fun search(query: String, page: Int = 1) {
        if (query.isNotEmpty()) {
            viewModelScope.launch {
                // Get Result
                _searchResult.value = searchUseCase.invoke(
                    query = query,
                    language = Const.getUserLanguage(),
                    page = page,
                    include_adult = false
                )
                // Divide results into entities
                _searchResult.value?.results?.let { results ->
                    val movieList = ArrayList<Movie>()
                    val tvShowList = ArrayList<TVShow>()
                    results.map {
                        when (it.media_type) {
                            "movie" -> movieList.add(DivideSearchResult().getMovie(it))
                            "tv" -> tvShowList.add(DivideSearchResult().getTVShow(it))
                            else -> null
                        }
                    }
                    _movies.value = movieList
                    _tvShows.value = tvShowList
                }
            }
        }
    }
}