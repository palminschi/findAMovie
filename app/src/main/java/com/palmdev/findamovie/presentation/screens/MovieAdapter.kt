package com.palmdev.findamovie.presentation.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.palmdev.findamovie.MAIN
import com.palmdev.findamovie.IMAGE_URL
import com.palmdev.findamovie.R
import com.palmdev.findamovie.domain.entity.movie.Movie
import com.palmdev.findamovie.presentation.screens.movie_bottom_sheet.MovieBottomSheetDialogFragment
import kotlinx.android.synthetic.main.item_movie_detailed.view.*
import kotlinx.android.synthetic.main.item_movie_detailed.view.movieImg
import kotlinx.android.synthetic.main.item_movie_detailed.view.movieTitle
import kotlinx.android.synthetic.main.item_movie_simple.view.*


class MovieAdapter(private val adapterType: AdapterType) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    enum class AdapterType { SIMPLE, DETAILED }

    private var listMovie = emptyList<Movie>()
    fun setMovies(list: List<Movie>) {
        listMovie = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layout = when (adapterType) {
            AdapterType.SIMPLE -> R.layout.item_movie_simple
            AdapterType.DETAILED -> R.layout.item_movie_detailed
        }
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return MovieViewHolder(view = view, adapterType = adapterType)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movie = listMovie[position])
    }

    override fun getItemCount(): Int {
        return listMovie.size
    }

    class MovieViewHolder(private val view: View, private val adapterType: AdapterType) :
        RecyclerView.ViewHolder(view) {

        fun bind(movie: Movie) {
            when (adapterType) {
                AdapterType.SIMPLE -> {
                    view.movieTitle.text = movie.title
                    view.movieVote.text = movie.vote_average.toString().subSequence(0,3)
                    Glide.with(view)
                        .load(IMAGE_URL + movie.poster_path)
                        .placeholder(R.drawable.image_loading)
                        .into(view.movieImg)
                }
                AdapterType.DETAILED -> {
                    view.movieTitle.text = movie.title
                    view.movieDate.text = movie.release_date
                    Glide.with(view)
                        .load(IMAGE_URL + movie.poster_path)
                        .placeholder(R.drawable.image_loading)
                        .into(view.movieImg)
                }
            }

            view.rootView.setOnClickListener {
                val bundle = Bundle()
                bundle.putSerializable(MOVIE_ARG, movie)
                bundle.putSerializable(
                    MovieBottomSheetDialogFragment.CONTENT_TYPE_ARG,
                    MovieBottomSheetDialogFragment.ContentType.MOVIE
                )
                MAIN.navController.navigate(R.id.movieBottomSheetDialogFragment, bundle)
            }
        }
    }


    companion object {
        const val MOVIE_ARG = "MOVIE_ARG"
    }
}