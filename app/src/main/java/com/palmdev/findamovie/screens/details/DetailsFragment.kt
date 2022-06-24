package com.palmdev.findamovie.screens.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.palmdev.findamovie.R
import com.palmdev.findamovie.databinding.FragmentDetailsBinding
import com.palmdev.findamovie.databinding.FragmentFavoritesBinding
import com.palmdev.findamovie.screens.favorites.FavoritesAdapter
import com.palmdev.findamovie.screens.favorites.FavoritesViewModel

class DetailsFragment : Fragment(R.layout.fragment_details) {

    private var mBinding: FragmentDetailsBinding? = null
    private val binding get() = mBinding!!
    private lateinit var viewModel: DetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentDetailsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        viewModel = ViewModelProvider(this)[DetailsViewModel::class.java]
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }

}