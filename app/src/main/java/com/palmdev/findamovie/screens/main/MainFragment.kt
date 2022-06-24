package com.palmdev.findamovie.screens.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.palmdev.findamovie.R
import com.palmdev.findamovie.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {

    private var mBinding: FragmentMainBinding? = null
    private val binding get() = mBinding!!
    private lateinit var recyclerView: RecyclerView
    private val adapter by lazy { MainAdapter() }
    private lateinit var viewModel: MainViewModel

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
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.getUpcomingMovies()
        recyclerView = binding.recViewMain
        recyclerView.adapter = adapter
        viewModel.upcomingMovies.observe(viewLifecycleOwner) { moviesPage ->
            moviesPage.body()?.results?.let { movies ->
                adapter.setMovies(list = movies)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }

}