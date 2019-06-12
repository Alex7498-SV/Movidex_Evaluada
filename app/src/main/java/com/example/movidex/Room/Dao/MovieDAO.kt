package com.example.movidex.Room.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movidex.Room.Entities.Movie

@Dao
interface MovieDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert (mov : Movie)

    @Query("SELECT * FROM Movie")
    fun getAllMovies() : LiveData<List<Movie>>

    @Query("SELECT * FROM Movie WHERE M_imbdID = (:ID)")
    fun getOneMovie(ID : Int) : LiveData<Movie>

    @Query("DELETE FROM Movie")
    suspend fun nuke()

}