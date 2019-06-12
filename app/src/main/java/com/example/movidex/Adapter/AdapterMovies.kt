package com.example.movidex.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movidex.R
import com.example.movidex.Room.Entities.Movie
import kotlinx.android.synthetic.main.recycleritem.view.*

class AdapterMovies(var movie : List<Movie>, var clickListener : (Movie) -> Unit) : RecyclerView.Adapter<AdapterMovies.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycleritem, parent, false))
    }

    override fun getItemCount(): Int = movie.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.onBind(movie[position], clickListener)

    internal fun setMovie(movie : List<Movie>){
        this.movie = movie
        notifyDataSetChanged()
    }

    class ViewHolder(var view : View) : RecyclerView.ViewHolder(view){
        fun onBind(movie : Movie, clickListener: (Movie) -> Unit){
            view.tv_title.text = movie.Title
            view.tv_calificion.text = movie.imdbRating
            Glide.with(itemView.context)
                .load(movie.Poster)
                .placeholder(R.drawable.ic_launcher_background)
                .into(view.iv_poster)
            view.tv_descripcion.text = movie.Plot
            view.tv_tiempo.text = movie.Runtime
        }
    }
}