package com.example.movidex.UI.Activities

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.movidex.UI.Adapter.AdapterMovies
import com.example.movidex.R
import com.example.movidex.Room.Entities.Movie
import com.example.movidex.ViewModel.MovieViewModel
import com.example.movidex.UI.Fragments.principalFragment
import com.example.movidex.UI.Fragments.secondFragment

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_principal.*

class MainActivity : AppCompatActivity(), principalFragment.OnFragmentInteractionListener {
    override fun onClickListenerPortrait(movie: Movie) {
        var intent = Intent(this, Main2Activity::class.java)
        intent.putExtra("movie", movie)
        startActivity(intent)
    }

    override fun onClickListenerLandscape(movie: Movie) {
        var fragment = secondFragment.newInstance(movie)

        supportFragmentManager.beginTransaction().replace(R.id.fragment_secundario, fragment).commit()
    }

    lateinit var viewModel : MovieViewModel
    private lateinit var adapter : AdapterMovies

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)

        if(fragment_secundario != null){
            var fragment = secondFragment.newInstance(Movie("N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A"))
            supportFragmentManager.beginTransaction().replace(R.id.fragment_secundario, fragment).commit()
        }

        btnAceptar.setOnClickListener {
            if (isNetworkAvailable()) {
                viewModel.retrievePelis(ed_buscar.text.toString())
            } else{
                Toast.makeText(this, "No tiene acceso a internet!", Toast.LENGTH_LONG).show()
            }
        }

    }

    fun isNetworkAvailable(): Boolean {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }
}
