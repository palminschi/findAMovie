package com.palmdev.findamovie.presentation.screens.tv_shows_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import com.palmdev.findamovie.R
import com.palmdev.findamovie.databinding.FragmentTvShowsListBinding
import com.palmdev.findamovie.presentation.screens.TVShowAdapter
import com.palmdev.findamovie.presentation.screens.movies_list.MoviesListFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class TVShowsListFragment : Fragment() {

    enum class SpinnerOption { TOP_RATED, POPULAR }

    private val viewModel: TVShowsListViewModel by viewModel()
    private var mBinding: FragmentTvShowsListBinding? = null
    private val binding get() = mBinding!!
    private val tvShowAdapter by lazy { TVShowAdapter(adapterType = TVShowAdapter.AdapterType.DETAILED) }
    private val currentPage = MutableLiveData<Int>()
    private var totalPages = MutableLiveData<Int>()
    private var spinnerPosition = 0
    private var spinnerOption = SpinnerOption.POPULAR

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentTvShowsListBinding.inflate(layoutInflater, container, false)
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
        binding.recyclerView.adapter = tvShowAdapter
        when (spinnerOption) {
            SpinnerOption.POPULAR -> binding.spinner.setSelection(0)
            SpinnerOption.TOP_RATED -> binding.spinner.setSelection(1)
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
                viewModel.getPopularTVShows(page = currentPage.value!!)
                viewModel.popularTVShows.observe(viewLifecycleOwner) {
                    tvShowAdapter.setTVShows(it.results)
                    totalPages.value = it.total_pages
                }
            }
            1 -> {
                viewModel.getTopRatedTVShows(page = currentPage.value!!)
                viewModel.topRatedTVShows.observe(viewLifecycleOwner) {
                    tvShowAdapter.setTVShows(it.results)
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