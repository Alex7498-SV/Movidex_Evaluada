package com.example.movidex.Room.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Movie")
class Movie(
    @PrimaryKey
    @ColumnInfo(name = "M_imbdID")
    val imdbID: String = "N/a",
    @ColumnInfo(name = "M_Title")
    val Title:String = "N/A",
    @ColumnInfo(name = "M_Year")
    val Year:String = "N/A",
    @ColumnInfo(name = "M_Released")
    val Released: String = "N/A",
    @ColumnInfo(name = "M_Runtime")
    val Runtime:String = "N/A",
    @ColumnInfo(name = "M_Genre")
    val Genre:String = "N/A",
    @ColumnInfo(name = "M_Director")
    val Director:String = "N/A",
    @ColumnInfo(name = "M_Actors")
    val Actors:String = "N/A",
    @ColumnInfo(name = "M_Plot")
    val Plot:String = "N/A",
    @ColumnInfo(name = "M_Languaje")
    val Language:String = "N/A",
    @ColumnInfo(name = "M_Rating")
    val imdbRating:String = "N/A",
    @ColumnInfo(name = "M_Poster")
    val Poster:String = "N/A"
){
}