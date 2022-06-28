package com.palmdev.findamovie.presentation.screens.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.palmdev.findamovie.MOVIE_IMAGE_PATH
import com.palmdev.findamovie.R
import com.palmdev.findamovie.databinding.FragmentDetailsBinding
import com.palmdev.findamovie.domain.entity.Movie
import com.palmdev.findamovie.presentation.screens.main.MainFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsFragment : Fragment(R.layout.fragment_details) {

    private var mBinding: FragmentDetailsBinding? = null
    private val binding get() = mBinding!!
    private val viewModel: DetailsViewModel by viewModel()
    private lateinit var currentMovie: Movie

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentDetailsBinding.inflate(layoutInflater, container, false)
        currentMovie = requireArguments().getSerializable(MainFragment.MOVIE_ARG) as Movie
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        binding.tvTitle.text = currentMovie.title
        binding.tvDate.text = currentMovie.release_date
        binding.tvDescription.text = currentMovie.overview
        Glide.with(requireActivity())
            .load(MOVIE_IMAGE_PATH + currentMovie.poster_path)
            .into(binding.movieImg)
        binding.btnAddToFavorites.setOnClickListener {
            viewModel.saveMovie(currentMovie)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }

}