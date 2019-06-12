package com.example.movidex.Room.Entities

import com.squareup.moshi.Json

data class busquedaRetro(
    @field:Json(name = "Response")
    var Respuesta: String,
    @field:Json(name = "Search")
    var Search: List<Movie>,
    @field:Json(name="Results")
    var Results : String
)