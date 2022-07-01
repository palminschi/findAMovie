package com.palmdev.findamovie.presentation.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.palmdev.findamovie.MAIN
import com.palmdev.findamovie.MOVIE_IMAGE_PATH
import com.palmdev.findamovie.R
import com.palmdev.findamovie.domain.entity.movie.Movie
import com.palmdev.findamovie.domain.entity.tvshow.TVShow
import com.palmdev.findamovie.presentation.screens.main.MainFragment
import kotlinx.android.synthetic.main.item_movie_detailed.view.*
import kotlinx.android.synthetic.main.item_movie_detailed.view.movieImg
import kotlinx.android.synthetic.main.item_movie_detailed.view.movieTitle
import kotlinx.android.synthetic.main.item_movie_simple.view.*



class TVShowAdapter(private val adapterType: AdapterType) :
    RecyclerView.Adapter<TVShowAdapter.TVShowViewHolder>() {

    enum class AdapterType { SIMPLE, DETAILED }

    private var listTVShow = emptyList<TVShow>()
    fun setTVShows(list: List<TVShow>) {
        listTVShow = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVShowViewHolder {
        val layout = when (adapterType) {
            AdapterType.SIMPLE -> R.layout.item_movie_simple
            AdapterType.DETAILED -> R.layout.item_movie_detailed
        }
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return TVShowViewHolder(view = view, adapterType = adapterType)
    }

    override fun onBindViewHolder(holder: TVShowViewHolder, position: Int) {
        holder.bind(tvShow = listTVShow[position])
    }

    override fun getItemCount(): Int {
        return listTVShow.size
    }

    class TVShowViewHolder(private val view: View, private val adapterType: AdapterType) :
        RecyclerView.ViewHolder(view) {

        fun bind(tvShow: TVShow) {
            when (adapterType) {
                AdapterType.SIMPLE -> {
                    view.movieTitle.text = tvShow.name
                    view.movieVote.text = tvShow.vote_average.toString()
                    Glide.with(view)
                        .load(MOVIE_IMAGE_PATH + tvShow.poster_path)
                        .placeholder(R.drawable.image_loading)
                        .into(view.movieImg)
                }
                AdapterType.DETAILED -> {
                    view.movieTitle.text = tvShow.name
                    view.movieDate.text = tvShow.first_air_date
                    Glide.with(view)
                        .load(MOVIE_IMAGE_PATH + tvShow.poster_path)
                        .placeholder(R.drawable.image_loading)
                        .into(view.movieImg)
                }
            }

            view.rootView.setOnClickListener {
                val bundle = Bundle()
                bundle.putSerializable(MainFragment.MOVIE_ARG, tvShow)
                MAIN.navController.navigate(R.id.detailsFragment, bundle) // TODO
            }
        }
    }


}