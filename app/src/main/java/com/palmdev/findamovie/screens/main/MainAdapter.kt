package com.palmdev.findamovie.screens.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.palmdev.findamovie.MOVIE_IMAGE_PATH
import com.palmdev.findamovie.R
import com.palmdev.findamovie.models.Movie
import com.palmdev.findamovie.models.MoviesPage
import kotlinx.android.synthetic.main.fragment_details.view.*
import kotlinx.android.synthetic.main.fragment_details.view.movieImg
import kotlinx.android.synthetic.main.item_movie.view.*

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private var listMovies = emptyList<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MainViewHolder(view = view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.itemView.movieTitle.text = listMovies[position].title
        holder.itemView.movieDate.text = listMovies[position].release_date

        Glide.with(holder.itemView)
            .load(MOVIE_IMAGE_PATH + listMovies[position].poster_path)
            .placeholder(R.drawable.ic_launcher_background) // TODO to change placeholder
            .into(holder.itemView.movieImg)
    }

    override fun getItemCount(): Int {
        return listMovies.size
    }

    fun setMovies(list: List<Movie>) {
        listMovies = list
        notifyDataSetChanged()
    }

    class MainViewHolder(view: View) : RecyclerView.ViewHolder(view)
}