package com.palmdev.findamovie.presentation.screens.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.palmdev.findamovie.MAIN
import com.palmdev.findamovie.R
import com.palmdev.findamovie.databinding.FragmentMainBinding
import com.palmdev.findamovie.domain.entity.Movie
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment(R.layout.fragment_main) {

    private var mBinding: FragmentMainBinding? = null
    private val binding get() = mBinding!!
    private lateinit var recyclerView: RecyclerView
    private val adapter by lazy { MainAdapter() }
    private val viewModel: MainViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        viewModel.getUpcomingMovies()
        recyclerView = binding.recViewMain
        recyclerView.adapter = adapter
        viewModel.upcomingMovies.observe(viewLifecycleOwner) { moviesPage ->
            moviesPage?.results?.let { movies ->
                adapter.setMovies(list = movies)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }

    companion object {

        const val MOVIE_ARG = "MOVIE_ARG"

        fun clickMovie(itemMovie: Movie) {
            val bundle = Bundle()
            bundle.putSerializable(MOVIE_ARG, itemMovie)
            MAIN.navController.navigate(R.id.action_mainFragment_to_detailsFragment, bundle)
        }
    }

}