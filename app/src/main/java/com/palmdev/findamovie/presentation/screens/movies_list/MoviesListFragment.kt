package com.palmdev.findamovie.presentation.screens.movies_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import com.palmdev.findamovie.databinding.FragmentMoviesListBinding
import com.palmdev.findamovie.presentation.screens.MovieAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MoviesListFragment : Fragment() {

    enum class SpinnerOption { NOW_PLAYING, UPCOMING, TOP_RATED, POPULAR }

    private val viewModel: MoviesListViewModel by viewModel()
    private var mBinding: FragmentMoviesListBinding? = null
    private val binding get() = mBinding!!
    private val movieAdapter by lazy { MovieAdapter(adapterType = MovieAdapter.AdapterType.DETAILED) }
    private val currentPage = MutableLiveData<Int>()
    private var totalPages = MutableLiveData<Int>()
    private var spinnerPosition = 0
    private var spinnerOption = SpinnerOption.NOW_PLAYING

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentMoviesListBinding.inflate(layoutInflater, container, false)
        arguments?.getSerializable(ARG_SELECTED_SPINNER_OPTION)?.let {
            spinnerOption = it as SpinnerOption
        }
        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        currentPage.value = 1
        init()
        updateMovies(spinnerPosition)
    }

    private fun init() {
        binding.recyclerView.adapter = movieAdapter
        when (spinnerOption) {
            SpinnerOption.NOW_PLAYING -> binding.spinner.setSelection(0)
            SpinnerOption.UPCOMING -> binding.spinner.setSelection(1)
            SpinnerOption.TOP_RATED -> binding.spinner.setSelection(2)
            SpinnerOption.POPULAR -> binding.spinner.setSelection(3)
        }
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                currentPage.value = 1
                spinnerPosition = position
                updateMovies(spinnerPosition)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        binding.btnNextPage.setOnClickListener {
            currentPage.value = currentPage.value?.plus(1)
            updateMovies(spinnerPosition)
        }
        binding.btnPreviousPage.setOnClickListener {
            currentPage.value = currentPage.value?.minus(1)
            updateMovies(spinnerPosition)
        }
        currentPage.observe(viewLifecycleOwner) {
            binding.tvCurrentPage.text = currentPage.value?.toString()
            if (currentPage.value == 1) {
                binding.btnPreviousPage.visibility = View.INVISIBLE
            } else binding.btnPreviousPage.visibility = View.VISIBLE
            if (currentPage.value == totalPages.value) {
                binding.btnNextPage.visibility = View.INVISIBLE
            } else binding.btnNextPage.visibility = View.VISIBLE
        }
        totalPages.observe(viewLifecycleOwner) {
            binding.tvTotalPages.text = it.toString()
        }
    }

    private fun updateMovies(spinnerPosition: Int) {
        when (spinnerPosition) {
            0 -> {
                viewModel.getNowPlayingMovies(page = currentPage.value!!)
                viewModel.nowPlayingMovies.observe(viewLifecycleOwner) {
                    movieAdapter.setMovies(it.results)
                    totalPages.value = it.total_pages
                }
            }
            1 -> {
                viewModel.getUpcomingMovies(page = currentPage.value!!)
                viewModel.upcomingMovies.observe(viewLifecycleOwner) {
                    movieAdapter.setMovies(it.results)
                    totalPages.value = it.total_pages
                }
            }
            2 -> {
                viewModel.getTopRatedMovies(page = currentPage.value!!)
                viewModel.topRatedMovies.observe(viewLifecycleOwner) {
                    movieAdapter.setMovies(it.results)
                    totalPages.value = it.total_pages
                }
            }
            3 -> {
                viewModel.getPopularMovies(page = currentPage.value!!)
                viewModel.popularMovies.observe(viewLifecycleOwner) {
                    movieAdapter.setMovies(it.results)
                    totalPages.value = it.total_pages
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }

    companion object {
        const val ARG_SELECTED_SPINNER_OPTION = "ARG_SELECTED_SPINNER_OPTION"
    }
}