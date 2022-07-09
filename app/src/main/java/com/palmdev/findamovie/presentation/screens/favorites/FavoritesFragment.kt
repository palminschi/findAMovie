package com.palmdev.findamovie.presentation.screens.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.palmdev.findamovie.R
import com.palmdev.findamovie.databinding.FragmentFavoritesBinding
import com.palmdev.findamovie.presentation.screens.MovieAdapter
import com.palmdev.findamovie.presentation.screens.TVShowAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoritesFragment : Fragment() {

    private var mBinding: FragmentFavoritesBinding? = null
    private val binding get() = mBinding!!
    private val movieAdapter by lazy { MovieAdapter(MovieAdapter.AdapterType.DETAILED) }
    private val tvShowAdapter by lazy { TVShowAdapter(TVShowAdapter.AdapterType.DETAILED) }
    private val viewModel: FavoritesViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentFavoritesBinding.inflate(layoutInflater, container, false)
        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        viewModel.getFavorites()
        binding.recViewFavorites.adapter = movieAdapter
        binding.tabLayout.addOnTabSelectedListener (object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab?.position == 0) {
                    binding.recViewFavorites.adapter = movieAdapter
                } else if (tab?.position == 1) {
                    binding.recViewFavorites.adapter = tvShowAdapter
                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
        viewModel.favoriteMovies.observe(viewLifecycleOwner) {
            movieAdapter.setMovies(it.asReversed())
        }
        viewModel.favoriteTVShows.observe(viewLifecycleOwner) {
            tvShowAdapter.setTVShows(it.asReversed())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }

}