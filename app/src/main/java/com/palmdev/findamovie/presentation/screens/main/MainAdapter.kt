package com.palmdev.findamovie.presentation.screens.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.palmdev.findamovie.MOVIE_IMAGE_PATH
import com.palmdev.findamovie.R
import com.palmdev.findamovie.domain.entity.Movie
import kotlinx.android.synthetic.main.item_movie.view.*


class MainAdapter : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private var listMovieEntities = emptyList<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MainViewHolder(view = view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.itemView.movieTitle.text = listMovieEntities[position].title
        holder.itemView.movieDate.text = listMovieEntities[position].release_date

        Glide.with(holder.itemView)
            .load(MOVIE_IMAGE_PATH + listMovieEntities[position].poster_path)
            .placeholder(R.drawable.ic_launcher_background) // TODO to change placeholder
            .into(holder.itemView.movieImg)
    }

    override fun getItemCount(): Int {
        return listMovieEntities.size
    }

    fun setMovies(list: List<Movie>) {
        listMovieEntities = list
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: MainViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener {
            MainFragment.clickMovie(listMovieEntities[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: MainViewHolder) {
        holder.itemView.setOnClickListener(null)
    }

    class MainViewHolder(view: View) : RecyclerView.ViewHolder(view)
}