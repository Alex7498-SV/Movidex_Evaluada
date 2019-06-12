package com.example.movidex.retrofit

import com.example.movidex.Room.Entities.Movie
import com.example.movidex.Room.Entities.busquedaRetro
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val MOVIE_DATABASE = "http://www.omdbapi.com/"

interface BusquedaRetrofit{

    @GET("/")
    fun obtenerPeliculas(@Query("s")clue : String, @Query("apikey") apikey : String) : Deferred<Response<busquedaRetro>>

    @GET("/")
    fun obtenerUna(@Query("i") id : String, @Query("apikey") apikey : String) : Deferred<Response<Movie>>

    companion object{
        fun getBusquedas() : BusquedaRetrofit{
            return Retrofit.Builder().baseUrl(MOVIE_DATABASE).addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory()).build().create(BusquedaRetrofit::class.java)
        }
    }

}