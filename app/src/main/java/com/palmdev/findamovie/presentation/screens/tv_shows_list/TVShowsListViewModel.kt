package com.palmdev.findamovie.presentation.screens.tv_shows_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.palmdev.findamovie.Const
import com.palmdev.findamovie.domain.entity.tvshow.TVShowsPage
import com.palmdev.findamovie.domain.usecase.tvshow.GetPopularTVShowsUseCase
import com.palmdev.findamovie.domain.usecase.tvshow.GetTopRatedTVShowsUseCase
import kotlinx.coroutines.launch

class TVShowsListViewModel(
    private val getTopRatedTVShowsUseCase: GetTopRatedTVShowsUseCase,
    private val getPopularTVShowsUseCase: GetPopularTVShowsUseCase
) : ViewModel() {

    private val _topRatedTVShows = MutableLiveData<TVShowsPage>()
    val topRatedTVShows: LiveData<TVShowsPage> = _topRatedTVShows

    private val _popularTVShows = MutableLiveData<TVShowsPage>()
    val popularTVShows: LiveData<TVShowsPage> = _popularTVShows

    fun getTopRatedTVShows(page: Int = 1) {
        viewModelScope.launch {
            _topRatedTVShows.value =
                getTopRatedTVShowsUseCase.invoke(language = Const.getUserLanguage(), page = page)
        }
    }

    fun getPopularTVShows(page: Int = 1) {
        viewModelScope.launch {
            _popularTVShows.value =
                getPopularTVShowsUseCase.invoke(language = Const.getUserLanguage(), page = page)
        }
    }
}