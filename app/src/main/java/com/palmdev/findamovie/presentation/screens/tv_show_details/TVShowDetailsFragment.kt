package com.palmdev.findamovie.presentation.screens.tv_show_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.palmdev.findamovie.IMAGE_URL
import com.palmdev.findamovie.R
import com.palmdev.findamovie.databinding.FragmentDetailsBinding
import com.palmdev.findamovie.domain.entity.movie.Movie
import com.palmdev.findamovie.domain.entity.tvshow.TVShow
import com.palmdev.findamovie.presentation.screens.MovieAdapter
import com.palmdev.findamovie.presentation.screens.TVShowAdapter
import com.palmdev.findamovie.presentation.screens.movie_details.MovieDetailsFragment
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import org.koin.androidx.viewmodel.ext.android.viewModel

class TVShowDetailsFragment : Fragment(R.layout.fragment_details) {

    private var mBinding: FragmentDetailsBinding? = null
    private val binding get() = mBinding!!
    private val viewModel: TVShowDetailsViewModel by viewModel()
    private var tvID: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentDetailsBinding.inflate(layoutInflater, container, false)
        tvID = requireArguments().getInt(TV_ID_ARG)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init(){
        viewModel.initTVShow(id = tvID)
        viewModel.getSimilarTVShows(tvID)

        // Details
        viewModel.tvShowDetails.observe(viewLifecycleOwner) { details ->
            binding.movieTitle.text = details.name
            binding.movieRating.text = details.vote_average.toString().subSequence(0, 3)
            binding.totalVotes.text = details.vote_count.toString()
            binding.movieReleaseDate.text = details.first_air_date
            binding.movieOverview.text = details.overview
            binding.numberOfSeasons.text = details.number_of_seasons.toString()
            if (details.tagline.isNullOrEmpty()) binding.movieTagline.visibility = View.GONE
            else {
                binding.movieTagline.visibility = View.VISIBLE
                binding.movieTagline.text = details.tagline
            }
            // Countries
            val countriesList = details.production_countries.map { it.name }
            var countriesString = ""
            for (i in countriesList.indices) {
                countriesString +=
                    if (i == countriesList.size - 1) {
                        countriesList[i]
                    } else {
                        "${countriesList[i]}, "
                    }
            }
            binding.movieCountries.text = countriesString
            // Image
            details.poster_path?.let {
                Glide.with(this)
                    .load(IMAGE_URL + it)
                    .placeholder(R.drawable.image_loading)
                    .into(binding.movieImg)
            }
            // Favorite Toggle Button
            var isFavorite: Boolean
            viewModel.favoriteTVShowsID.observe(viewLifecycleOwner) {
                isFavorite = it.contains(details.id.toString())
                binding.favoriteToggleBtn.isChecked = isFavorite
            }
            binding.favoriteToggleBtn.setOnCheckedChangeListener { _, boolean ->
                when (boolean) {
                    true -> viewModel.saveTVShow(
                        TVShow(
                            id = details.id,
                            backdrop_path = details.backdrop_path,
                            first_air_date = details.first_air_date,
                            original_language = details.original_language,
                            original_name = details.original_name,
                            overview = details.overview,
                            name = details.name,
                            popularity = details.popularity,
                            poster_path = details.poster_path,
                            vote_average = details.vote_average,
                            vote_count = details.vote_count
                        )
                    )
                    false -> viewModel.deleteTVShow(details.id)
                }
            }
        }
        // Similar Movies
        val similarMoviesAdapter = TVShowAdapter(adapterType = TVShowAdapter.AdapterType.SIMPLE)
        binding.similarRecyclerView.adapter = similarMoviesAdapter
        viewModel.similarTVShows.observe(viewLifecycleOwner) { tvShowsPage ->
            similarMoviesAdapter.setTVShows(tvShowsPage.results)
        }

        // Video Trailer
        viewModel.tvShowVideo.observe(viewLifecycleOwner) { videoInfo ->
            videoInfo?.let {
                lifecycle.addObserver(binding.youtubePlayerView)
                binding.youtubePlayerView.addYouTubePlayerListener(
                    YouTubePlayerListener(
                        videoInfo.key,
                        binding.youtubePlayerView
                    )
                )
            }
        }

        // Reviews
        viewModel.tvShowReview.observe(viewLifecycleOwner) {
            // TODO Reviews
        }
    }

    private class YouTubePlayerListener(
        private val videoID: String,
        private val view: YouTubePlayerView
    ) : AbstractYouTubePlayerListener() {

        override fun onReady(youTubePlayer: YouTubePlayer) {
            super.onReady(youTubePlayer)
            youTubePlayer.loadVideo(videoID, startSeconds = 0.0f)
            youTubePlayer.mute()
            youTubePlayer.play()
            view.visibility = View.VISIBLE
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }

    companion object {
        const val TV_ID_ARG = "TV_ID"
    }
}