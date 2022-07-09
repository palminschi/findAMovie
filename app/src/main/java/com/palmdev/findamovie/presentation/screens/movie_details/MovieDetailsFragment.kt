package com.palmdev.findamovie.presentation.screens.movie_details

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.palmdev.findamovie.IMAGE_URL
import com.palmdev.findamovie.R
import com.palmdev.findamovie.YOUTUBE_API_KEY
import com.palmdev.findamovie.databinding.FragmentDetailsBinding
import com.palmdev.findamovie.domain.entity.movie.Movie
import com.palmdev.findamovie.presentation.screens.MovieAdapter
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieDetailsFragment : Fragment(R.layout.fragment_details) {

    private var mBinding: FragmentDetailsBinding? = null
    private val binding get() = mBinding!!
    private val viewModel: MovieDetailsViewModel by viewModel()
    private var movieID: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentDetailsBinding.inflate(layoutInflater, container, false)
        movieID = requireArguments().getInt(MOVIE_ID_ARG)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        viewModel.initMovie(movieID)
        viewModel.getSimilarMovies(movieID)
        binding.tvSeasons.visibility = View.GONE
        binding.numberOfSeasons.visibility = View.GONE

        // Details
        viewModel.movieDetails.observe(viewLifecycleOwner) { details ->
            binding.movieTitle.text = details.title
            binding.movieRating.text = details.vote_average.toString().subSequence(0, 3)
            binding.totalVotes.text = details.vote_count.toString()
            binding.movieReleaseDate.text = details.release_date
            binding.movieOverview.text = details.overview
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
            viewModel.favoriteMoviesID.observe(viewLifecycleOwner) {
                isFavorite = it.contains(details.id.toString())
                binding.favoriteToggleBtn.isChecked = isFavorite
            }
            binding.favoriteToggleBtn.setOnCheckedChangeListener { _, boolean ->
                when (boolean) {
                    true -> viewModel.saveMovie(
                        Movie(
                            id = details.id,
                            adult = details.adult,
                            backdrop_path = details.backdrop_path,
                            original_language = details.original_language,
                            original_title = details.original_title,
                            overview = details.overview,
                            popularity = details.popularity,
                            poster_path = details.poster_path,
                            release_date = details.release_date,
                            title = details.title,
                            video = details.video,
                            vote_average = details.vote_average,
                            vote_count = details.vote_count
                        )
                    )
                    false -> viewModel.deleteMovie(movieID = details.id)
                }
            }
        }
        // Similar Movies
        val similarMoviesAdapter = MovieAdapter(adapterType = MovieAdapter.AdapterType.SIMPLE)
        binding.similarRecyclerView.adapter = similarMoviesAdapter
        viewModel.similarMovies.observe(viewLifecycleOwner) { moviesPage ->
            similarMoviesAdapter.setMovies(moviesPage.results)
        }

        // Video Trailer
        viewModel.movieVideo.observe(viewLifecycleOwner) { videoInfo ->
            lifecycle.addObserver(binding.youtubePlayerView)
            binding.youtubePlayerView.addYouTubePlayerListener(
                YouTubePlayerListener(
                    videoInfo.key,
                    binding.youtubePlayerView
                )
            )

        }

        // Reviews
        viewModel.movieReview.observe(viewLifecycleOwner) {
            // TODO Reviews
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
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

    companion object {
        const val MOVIE_ID_ARG = "MOVIE_ID_ARG"
    }
}