package com.example.movidex

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.Uri
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movidex.Adapter.AdapterMovies
import com.example.movidex.Room.Entities.Movie
import com.example.movidex.ViewModel.MovieViewModel

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_principal.*

class MainActivity : AppCompatActivity(), principalFragment.OnFragmentInteractionListener , secondFragment.OnFragmentInteractionListener{
    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFragmentInteraction(movie : Movie) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    lateinit var viewModel : MovieViewModel
    private lateinit var adapter : AdapterMovies

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)

        if(fragment_secundario != null){
            supportFragmentManager.beginTransaction().replace(R.id.fragment_secundario, secondFragment()).commit()
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
