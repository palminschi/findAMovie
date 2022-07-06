package com.palmdev.findamovie.presentation.screens.tv_show_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.palmdev.findamovie.Const
import com.palmdev.findamovie.domain.entity.ListOfReviews
import com.palmdev.findamovie.domain.entity.VideoInfo
import com.palmdev.findamovie.domain.entity.tvshow.TVShow
import com.palmdev.findamovie.domain.entity.tvshow.TVShowDetails
import com.palmdev.findamovie.domain.entity.tvshow.TVShowsPage
import com.palmdev.findamovie.domain.usecase.tvshow.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TVShowDetailsViewModel(
    private val getTVShowDetailsUseCase: GetTVShowDetailsUseCase,
    private val getTVShowVideoUseCase: GetTVShowVideoUseCase,
    private val getTVShowReviewsUseCase: GetTVShowReviewsUseCase,
    private val getFavoriteTVShowsIDUseCase: GetFavoriteTVShowsIDUseCase,
    private val saveFavoriteTVShowUseCase: SaveFavoriteTVShowUseCase,
    private val deleteFavoriteTVShowUseCase: DeleteFavoriteTVShowUseCase,
    private val getSimilarTVShowsUseCase: GetSimilarTVShowsUseCase
) : ViewModel() {

    private val _favoriteTVShowsID = MutableLiveData<List<String>>()
    val favoriteTVShowsID: LiveData<List<String>> = _favoriteTVShowsID
    private val _tvShowDetails = MutableLiveData<TVShowDetails>()
    val tvShowDetails: LiveData<TVShowDetails> = _tvShowDetails
    private val _tvShowVideo = MutableLiveData<VideoInfo>()
    val tvShowVideo: LiveData<VideoInfo> = _tvShowVideo
    private val _tvShowReviews = MutableLiveData<ListOfReviews>()
    val tvShowReview: LiveData<ListOfReviews> = _tvShowReviews
    private val _similarTVShows = MutableLiveData<TVShowsPage>()
    val similarTVShows: LiveData<TVShowsPage> = _similarTVShows

    init {
        viewModelScope.launch {
            _favoriteTVShowsID.value = getFavoriteTVShowsIDUseCase.invoke()
        }
    }

    fun initTVShow(id: Int) {
        viewModelScope.launch {
            _tvShowDetails.value = getTVShowDetailsUseCase.invoke(
                tvID = id,
                language = Const.getUserLanguage()
            )
            _tvShowVideo.value = getTVShowVideoUseCase.invoke(
                tvID = id,
                language = Const.getUserLanguage()
            )
            _tvShowReviews.value = getTVShowReviewsUseCase.invoke(
                tvID = id,
                language = Const.getUserLanguage()
            )
        }
    }

    fun saveTVShow(tvShow: TVShow) {
        viewModelScope.launch(Dispatchers.IO) {
            saveFavoriteTVShowUseCase.invoke(tvShow)
        }
    }

    fun deleteTVShow(tvID: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteFavoriteTVShowUseCase.invoke(tvID)
        }
    }

    fun getSimilarTVShows(tvID: Int) {
        viewModelScope.launch {
            _similarTVShows.value = getSimilarTVShowsUseCase.invoke(tvID, Const.getUserLanguage())
        }
    }
}