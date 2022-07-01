package com.palmdev.findamovie.presentation.screens.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.palmdev.findamovie.R
import com.palmdev.findamovie.databinding.FragmentMainBinding
import com.palmdev.findamovie.presentation.screens.MovieAdapter
import com.palmdev.findamovie.presentation.screens.TVShowAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment(R.layout.fragment_main) {

    private var mBinding: FragmentMainBinding? = null
    private val binding get() = mBinding!!
    private val adapter by lazy { MovieAdapter(adapterType = MovieAdapter.AdapterType.SIMPLE) }
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
        viewModel.getMovies()
        binding.searchEditText.clearFocus()
        binding.searchEditText.focusable = View.NOT_FOCUSABLE

        val nowPlayingMoviesAdapter = MovieAdapter(MovieAdapter.AdapterType.SIMPLE)
        val popularTVShowsAdapter = TVShowAdapter(TVShowAdapter.AdapterType.SIMPLE)
        val upcomingMoviesAdapter = MovieAdapter(MovieAdapter.AdapterType.SIMPLE)
        val topRatedTVAdapter = TVShowAdapter(TVShowAdapter.AdapterType.SIMPLE)
        val popularMoviesAdapter = MovieAdapter(MovieAdapter.AdapterType.SIMPLE)
        val topRatedMoviesAdapter = MovieAdapter(MovieAdapter.AdapterType.SIMPLE)

        binding.nowPlayingMoviesRecyclerView.adapter = nowPlayingMoviesAdapter
        binding.popularTVShowsRecyclerView.adapter = popularTVShowsAdapter
        binding.upcomingRecyclerView.adapter = upcomingMoviesAdapter
        binding.topRatedTVRecyclerView.adapter = topRatedTVAdapter
        binding.popularMoviesRecyclerView.adapter = popularMoviesAdapter
        binding.topRatedMoviesRecyclerView.adapter = topRatedMoviesAdapter


        viewModel.upcomingMovies.observe(viewLifecycleOwner) { moviesPage ->
            moviesPage?.results?.let { movies ->
                upcomingMoviesAdapter.setMovies(list = movies)
            }
        }
        viewModel.nowPlayingMovies.observe(viewLifecycleOwner) { moviesPage ->
            moviesPage?.results?.let { movies ->
                nowPlayingMoviesAdapter.setMovies(list = movies)
            }
        }
        viewModel.popularTVShows.observe(viewLifecycleOwner) { moviesPage ->
            moviesPage?.results?.let { list ->
                popularTVShowsAdapter.setTVShows(list = list)
            }
        }
        viewModel.topRatedTVShows.observe(viewLifecycleOwner) { moviesPage ->
            moviesPage?.results?.let { list ->
                topRatedTVAdapter.setTVShows(list = list)
            }
        }
        viewModel.popularMovies.observe(viewLifecycleOwner) { moviesPage ->
            moviesPage?.results?.let { list ->
                popularMoviesAdapter.setMovies(list = list)
            }
        }
        viewModel.topRatedMovies.observe(viewLifecycleOwner) { moviesPage ->
            moviesPage?.results?.let { list ->
                topRatedMoviesAdapter.setMovies(list = list)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }

    companion object {
        const val MOVIE_ARG = "MOVIE_ARG"
    }

}