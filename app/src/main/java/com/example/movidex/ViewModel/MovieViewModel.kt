package com.example.movidex.ViewModel

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.movidex.Repository.MovieRepo
import com.example.movidex.Room.Entities.Movie
import com.example.movidex.Room.RoomDB.RoomMovieDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieViewModel(var app: Application): AndroidViewModel(app) {

    private var repository:MovieRepo

    init{
        val movieDao = RoomMovieDB.getDatabase(app).moviedao()
        repository = MovieRepo(movieDao)
    }

    fun insert(movie: Movie) = viewModelScope.launch(Dispatchers.IO) {
        repository!!.insert(movie)
    }

    fun getAll():LiveData<List<Movie>> = repository!!.getAll()

    fun getOne(id: Int) = repository!!.getOne(id)

    fun nuke() = viewModelScope.launch(Dispatchers.IO) {
        repository.nuke()
    }

    fun retrievePelis(eje : String) = viewModelScope.launch(Dispatchers.IO) {
        val response = repository?.retrieveRepoAsync(eje)?.await()
        if (response!!.isSuccessful) with(response?.body()?.Search){
            this?.forEach{
                insertMovie(it.imdbID)
            }
        } else with(response){
            when(this.code()){
                404 -> {
                    Toast.makeText(app, "Error", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    fun insertMovie(id : String) = viewModelScope.launch {
        val response2 = repository?.retrieveRepoOneAsync(id).await()
        if (response2.isSuccessful) with(response2.body()) {
            this@MovieViewModel.insert(this!!)
        }
    }

}