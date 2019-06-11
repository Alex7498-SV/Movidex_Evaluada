package com.example.movidex.Room.RoomDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.movidex.Room.Dao.MovieDAO
import com.example.movidex.Room.Entities.Movie

@Database(entities = arrayOf(Movie::class), version = 1)
public abstract class RoomMovieDB : RoomDatabase(){

    abstract fun moviedao() : MovieDAO

    companion object{
        @Volatile
        private var INSTANCE : RoomMovieDB? = null

        fun getDatabase(context: Context): RoomMovieDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RoomMovieDB::class.java,
                    "Movies"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}