package com.palmdev.findamovie.presentation.screens.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.palmdev.findamovie.MOVIE_IMAGE_PATH
import com.palmdev.findamovie.R
import com.palmdev.findamovie.databinding.FragmentDetailsBinding
import com.palmdev.findamovie.data.entity.MovieEntity
import com.palmdev.findamovie.presentation.screens.main.MainFragment

class DetailsFragment : Fragment(R.layout.fragment_details) {

    private var mBinding: FragmentDetailsBinding? = null
    private val binding get() = mBinding!!
    private lateinit var viewModel: DetailsViewModel
    private lateinit var currentMovieEntity: MovieEntity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentDetailsBinding.inflate(layoutInflater, container, false)
        currentMovieEntity = requireArguments().getSerializable(MainFragment.MOVIE_ARG) as MovieEntity
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        viewModel = ViewModelProvider(this)[DetailsViewModel::class.java]

        binding.tvTitle.text = currentMovieEntity.title
        binding.tvDate.text = currentMovieEntity.release_date
        binding.tvDescription.text = currentMovieEntity.overview
        Glide.with(requireActivity())
            .load(MOVIE_IMAGE_PATH + currentMovieEntity.poster_path)
            .into(binding.movieImg)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }

}