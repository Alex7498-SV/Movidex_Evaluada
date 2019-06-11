package com.example.movidex.Repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.movidex.Room.Dao.MovieDAO
import com.example.movidex.Room.Entities.Movie

class MovieRepo (private val movieDao : MovieDAO) {

    val allPartidos: LiveData<List<Movie>> = movieDao.getAllMovies()

    @WorkerThread
    suspend fun insert(movie: Movie) {
        movieDao.insert(movie)
    }

    fun getAll(): LiveData<List<Movie>> = movieDao.getAllMovies()

    fun getOne(id: Int) = movieDao.getOneMovie(id)

}