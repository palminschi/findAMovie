package com.palmdev.findamovie.presentation.screens.movie_bottom_sheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.palmdev.findamovie.IMAGE_URL
import com.palmdev.findamovie.R
import com.palmdev.findamovie.databinding.FragmentMovieBottomSheetDialogBinding
import com.palmdev.findamovie.domain.entity.movie.Movie
import com.palmdev.findamovie.domain.entity.tvshow.TVShow
import com.palmdev.findamovie.presentation.screens.MovieAdapter
import com.palmdev.findamovie.presentation.screens.TVShowAdapter
import com.palmdev.findamovie.presentation.screens.movie_details.MovieDetailsFragment
import com.palmdev.findamovie.presentation.screens.tv_show_details.TVShowDetailsFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class MovieBottomSheetDialogFragment : BottomSheetDialogFragment() {

    enum class ContentType { MOVIE, TV_SHOW }

    private var mBinding: FragmentMovieBottomSheetDialogBinding? = null
    private val binding get() = mBinding!!
    private val viewModel: MovieBottomSheetViewModel by viewModel()
    private var contentType: ContentType? = null
    private var movie: Movie? = null
    private var tvShow: TVShow? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentMovieBottomSheetDialogBinding.inflate(layoutInflater, container, false)
        contentType = arguments?.getSerializable(CONTENT_TYPE_ARG) as ContentType
        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        when (contentType) {
            ContentType.MOVIE -> {
                movie = arguments?.getSerializable(MovieAdapter.MOVIE_ARG) as Movie
                initMovie()
            }
            ContentType.TV_SHOW -> {
                tvShow = arguments?.getSerializable(TVShowAdapter.TV_SHOW_ARG) as TVShow
                initTVShow()
            }
            null -> onDestroyView()
        }
    }

    private fun initMovie() {
        movie?.let { movie ->
            binding.movieTitle.text = movie.title
            binding.movieOverview.text = movie.overview
            binding.movieRate.text = movie.vote_average.toString()
            binding.movieReleaseDate.text = movie.release_date
            movie.poster_path?.let { poster_path ->
                Glide.with(this)
                    .load(IMAGE_URL + poster_path)
                    .placeholder(R.drawable.image_loading)
                    .into(binding.movieImg)
            }
            // Favorite Toggle Button
            val favoriteMoviesID = viewModel.favoriteMoviesID.value
            val isFavoriteMovie = favoriteMoviesID?.contains(movie.id.toString()) == true
            binding.favoriteToggleBtn.isChecked = isFavoriteMovie
            binding.favoriteToggleBtn.setOnCheckedChangeListener { _, isFavorite ->
                when (isFavorite) {
                    true -> viewModel.saveMovie(movie)
                    false -> viewModel.deleteMovie(movie.id)
                }
            }
            // Navigation
            binding.root.setOnClickListener {
                findNavController().navigate(
                    R.id.action_movieBottomSheetDialogFragment_to_movieDetailsFragment,
                    bundleOf(MovieDetailsFragment.MOVIE_ID_ARG to movie.id)
                )
            }
        }
    }

    private fun initTVShow() {
        tvShow?.let { tvShow ->
            binding.movieTitle.text = tvShow.name
            binding.movieOverview.text = tvShow.overview
            binding.movieRate.text = tvShow.vote_average.toString().subSequence(0,3)
            binding.movieReleaseDate.text = tvShow.first_air_date
            tvShow.poster_path?.let { poster_path ->
                Glide.with(this)
                    .load(IMAGE_URL + poster_path)
                    .placeholder(R.drawable.image_loading)
                    .into(binding.movieImg)
            }
            // Favorite Toggle Button
            val favoriteTVShowsID = viewModel.favoriteTVShowsID.value
            val isFavoriteTVShow = favoriteTVShowsID?.contains(tvShow.id.toString()) == true
            binding.favoriteToggleBtn.isChecked = isFavoriteTVShow
            binding.favoriteToggleBtn.setOnCheckedChangeListener { _, isFavorite ->
                when (isFavorite) {
                    true -> viewModel.saveTVShow(tvShow)
                    false -> viewModel.deleteTVShow(tvShow.id)
                }
            }
            // Navigation
            binding.root.setOnClickListener {
                findNavController().navigate(
                    R.id.action_movieBottomSheetDialogFragment_to_TVShowDetailsFragment,
                    bundleOf(TVShowDetailsFragment.TV_ID_ARG to tvShow.id)
                )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }

    companion object {
        const val CONTENT_TYPE_ARG = "CONTENT_TYPE_ARG"
    }
}