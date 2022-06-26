package com.palmdev.findamovie.presentation.screens.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.palmdev.findamovie.R
import com.palmdev.findamovie.databinding.FragmentFavoritesBinding

class FavoritesFragment : Fragment(R.layout.fragment_favorites) {

    private var mBinding: FragmentFavoritesBinding? = null
    private val binding get() = mBinding!!
    private lateinit var recyclerView: RecyclerView
    private val adapter by lazy { FavoritesAdapter() }
    private lateinit var viewModel: FavoritesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentFavoritesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        viewModel = ViewModelProvider(this)[FavoritesViewModel::class.java]
        recyclerView = binding.recViewFavorites
        //recyclerView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }

}