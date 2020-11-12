package com.tm.canomariaayelen.appi


import com.tm.canomariaayelen.model.Objeto
import com.tm.canomariaayelen.model.Pelicula
import retrofit2.Call
import retrofit2.http.GET
import java.util.*

interface IPeliculaService {
    @GET("list/1?api_key=32032564978a1c288fa5874397c2a0bf&language=es-ES")
    fun  obtenerLista(): Call<Objeto>
    
}