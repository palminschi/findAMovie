package com.palmdev.findamovie.presentation.screens.search

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.core.os.bundleOf
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import com.palmdev.findamovie.R
import com.palmdev.findamovie.databinding.FragmentSearchBinding
import com.palmdev.findamovie.domain.entity.movie.Movie
import com.palmdev.findamovie.presentation.MainActivity
import com.palmdev.findamovie.presentation.screens.MovieAdapter
import com.palmdev.findamovie.presentation.screens.TVShowAdapter
import kotlinx.android.synthetic.main.fragment_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : Fragment() {

    private val viewModel: SearchViewModel by viewModel()
    private var mBinding: FragmentSearchBinding? = null
    private val binding get() = mBinding!!
    private val searchQuery = MutableLiveData<String>()
    private val moviesAdapter by lazy { MovieAdapter(adapterType = MovieAdapter.AdapterType.SIMPLE) }
    private val tvShowsAdapter by lazy { TVShowAdapter(adapterType = TVShowAdapter.AdapterType.SIMPLE) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentSearchBinding.inflate(layoutInflater, container, false)
        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    override fun onResume() {
        super.onResume()
        binding.searchEditText.requestFocus()
        MainActivity.openKeyboard(binding.searchEditText)
    }

    private fun init() {
        searchQuery.observe(viewLifecycleOwner) {
            viewModel.search(query = it)
        }
        binding.searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                if (s.length > 3) {
                    searchQuery.value = s.toString()
                }
                if (s.isNotEmpty()) binding.btnClear.visibility = View.VISIBLE
                else binding.btnClear.visibility = View.GONE
            }
        })
        binding.searchEditText.setOnEditorActionListener { textView, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                searchQuery.value = textView.text.toString()
                return@setOnEditorActionListener true
            }
            return@setOnEditorActionListener false
        }
        binding.btnClear.setOnClickListener { binding.searchEditText.setText("") }
        binding.btnClear.visibility = View.GONE
        binding.tvMovies.visibility = View.GONE
        binding.tvTVShows.visibility = View.GONE
        binding.tvPersons.visibility = View.GONE
        binding.moviesRecyclerView.visibility = View.GONE
        binding.tvShowsRecyclerView.visibility = View.GONE
        binding.personsRecyclerView.visibility = View.GONE

        // Recycler Views
        binding.moviesRecyclerView.adapter = moviesAdapter
        binding.tvShowsRecyclerView.adapter = tvShowsAdapter

        viewModel.movies.observe(viewLifecycleOwner) {
            moviesAdapter.setMovies(it)
            binding.tvMovies.visibility = View.VISIBLE
            binding.moviesRecyclerView.visibility = View.VISIBLE
        }
        viewModel.tvShows.observe(viewLifecycleOwner) {
            tvShowsAdapter.setTVShows(it)
            binding.tvTVShows.visibility = View.VISIBLE
            binding.tvShowsRecyclerView.visibility = View.VISIBLE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }
}