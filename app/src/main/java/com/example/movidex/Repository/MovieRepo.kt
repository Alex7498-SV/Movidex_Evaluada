package com.example.movidex.Repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.movidex.Room.Dao.MovieDAO
import com.example.movidex.Room.Entities.Movie
import com.example.movidex.Room.Entities.busquedaRetro
import com.example.movidex.Retrofit.BusquedaRetrofit
import kotlinx.coroutines.Deferred
import retrofit2.Response

class MovieRepo (private val movieDao : MovieDAO) {

    fun retrieveRepoAsync(eje : String) : Deferred<Response<busquedaRetro>>{
        val apikey = "4babb186"
        return BusquedaRetrofit.getBusquedas().obtenerPeliculas(eje, apikey)
    }

    fun retrieveRepoOneAsync(id : String) : Deferred<Response<Movie>>{
        val apikey = "4babb186"
        return BusquedaRetrofit.getBusquedas().obtenerUna(id, apikey)
    }


    val allPartidos: LiveData<List<Movie>> = movieDao.getAllMovies()

    @WorkerThread
    suspend fun insert(movie: Movie) {
        movieDao.insert(movie)
    }

    @WorkerThread
    suspend fun nuke() = movieDao.nuke()

    fun getAll(): LiveData<List<Movie>> = movieDao.getAllMovies()

    fun getOne(id: Int) = movieDao.getOneMovie(id)

}