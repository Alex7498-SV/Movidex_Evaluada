package com.example.movidex.UI.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.movidex.R
import com.example.movidex.Room.Entities.Movie
import kotlinx.android.synthetic.main.fragment_second.view.*

class secondFragment : Fragment() {

    private var movie = Movie("N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A")

    companion object {
        fun newInstance(movie : Movie) : secondFragment {
            var instance = secondFragment()
            instance.movie = movie
            return instance
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_second, container, false)
        view.tv_sinopsis_fragment.text = movie.Plot
        view.tv_titulo_fragment.text = movie.Title
        view.tv_actores_fragment.text = movie.Actors
        view.tv_puntos_fragment.text = movie.imdbRating
        view.tv_anio_fragment.text = movie.Year
        view.tv_genero_fragment.text = movie.Genre
        view.tv_duracion_fragment.text = movie.Runtime
        view.tv_director_fragment.text = movie.Director

        Glide.with(view.context)
                .load(movie.Poster)
                .placeholder(R.drawable.ic_launcher_background)
                .into(view.iv_imagen_fragment)
        return view
    }
}
