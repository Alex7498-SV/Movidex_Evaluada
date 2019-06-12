package com.example.movidex.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.movidex.Repository.MovieRepo
import com.example.movidex.Room.Entities.Movie
import com.example.movidex.Room.RoomDB.RoomMovieDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieViewModel(app: Application): AndroidViewModel(app) {

    private var repository:MovieRepo?=null

    init{
        val movieDao = RoomMovieDB.getDatabase(app).moviedao()
        repository = MovieRepo(movieDao)
    }

    fun insert(movie: Movie) = viewModelScope.launch(Dispatchers.IO) {
        repository!!.insert(movie)
    }

    fun getAll():LiveData<List<Movie>> = repository!!.getAll()

    fun getOne(id: Int) = repository!!.getOne(id)


}