package com.palmdev.findamovie.presentation.screens.main

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.palmdev.findamovie.R
import com.palmdev.findamovie.databinding.FragmentMainBinding
import com.palmdev.findamovie.presentation.screens.MovieAdapter
import com.palmdev.findamovie.presentation.screens.TVShowAdapter
import com.palmdev.findamovie.presentation.screens.movies_list.MoviesListFragment
import com.palmdev.findamovie.presentation.screens.search.SearchFragment
import com.palmdev.findamovie.presentation.screens.tv_shows_list.TVShowsListFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainFragment : Fragment() {

    private var mBinding: FragmentMainBinding? = null
    private val binding get() = mBinding!!
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

        binding.searchEditText.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_searchFragment)
        }

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

        binding.moreNowPlayingMoviesButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_mainFragment_to_moviesListFragment,
                bundleOf(MoviesListFragment.ARG_SELECTED_SPINNER_OPTION to MoviesListFragment.SpinnerOption.NOW_PLAYING)
            )
        }
        binding.moreUpcomingButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_mainFragment_to_moviesListFragment,
                bundleOf(MoviesListFragment.ARG_SELECTED_SPINNER_OPTION to MoviesListFragment.SpinnerOption.UPCOMING)
            )
        }
        binding.moreTopRatedMoviesButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_mainFragment_to_moviesListFragment,
                bundleOf(MoviesListFragment.ARG_SELECTED_SPINNER_OPTION to MoviesListFragment.SpinnerOption.TOP_RATED)
            )
        }
        binding.morePopularMoviesButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_mainFragment_to_moviesListFragment,
                bundleOf(MoviesListFragment.ARG_SELECTED_SPINNER_OPTION to MoviesListFragment.SpinnerOption.POPULAR)
            )
        }
        binding.moreTopRatedTVButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_mainFragment_to_TVShowsListFragment,
                bundleOf(TVShowsListFragment.ARG_SELECTED_SPINNER_OPTION to TVShowsListFragment.SpinnerOption.TOP_RATED)
            )
        }
        binding.morePopularTVShowsButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_mainFragment_to_TVShowsListFragment,
                bundleOf(TVShowsListFragment.ARG_SELECTED_SPINNER_OPTION to TVShowsListFragment.SpinnerOption.POPULAR)
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }
}