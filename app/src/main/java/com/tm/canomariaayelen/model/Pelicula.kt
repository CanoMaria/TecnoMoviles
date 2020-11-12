package com.tm.canomariaayelen.model

import com.google.gson.annotations.SerializedName

data class Pelicula(

   @SerializedName("vote_count") var cant_votos:Int?= 0,
   @SerializedName("popularity") var popularidad: Double = 0.0,
   @SerializedName("id")         var id: Int?= 0,
   @SerializedName("video")      var video: Boolean? = false,
   @SerializedName("media_type") var tipo: String? = "",
   @SerializedName("vote_average")     var puntuacion: Double = 0.0,
   @SerializedName("title")            var titulo: String? = "",
   @SerializedName("release_date")     var año: String?= "",
   @SerializedName("original_language")var lenguaje: String?= "",
   @SerializedName("original_title")   var titulo_original: String?= "",
   @SerializedName("genre_ids")        var id_generos: ArrayList<Int>?,
   @SerializedName("backdrop_path")    var backdrop: String?= "",
   @SerializedName("adult")            var adulto: Boolean? = false,
   @SerializedName("overview")         var descripcion: String?= "",
   @SerializedName("poster_path")      var poster: String?= ""
)