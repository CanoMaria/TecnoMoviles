package com.tm.canomariaayelen;

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainApp: AppCompatActivity(){

        val peliculas= mutableListOf<Pelicula>()
        override fun onCreate(savedInstanceState: Bundle?){
                super.onCreate(savedInstanceState)
                setContentView(R.layout.main)

                val recyclerView : RecyclerView = findViewById<RecyclerView>(R.id.lista)  //encuentro el recyclerView
                recyclerView.setLayoutManager(LinearLayoutManager(this))
                recyclerView.adapter = Adapter(cargarPelis())



        }

    private fun cargarPelis(): List<Pelicula> {

        peliculas.add(Pelicula(nombre = getString(R.string.mulan), imagen = R.drawable.mulan))
        peliculas.add(Pelicula(nombre = getString(R.string.cab_zodiaco), imagen = R.drawable.caballeros_zodiaco))
        peliculas.add(Pelicula(nombre = getString(R.string.rey_leon), imagen = R.drawable.rey_leon))
        peliculas.add(Pelicula(nombre = getString(R.string.dragon_ball), imagen = R.drawable.dragon_ball))
        peliculas.add(Pelicula(nombre = getString(R.string.sailor_moon), imagen = R.drawable.sailor_moon))
        peliculas.add(Pelicula(nombre = getString(R.string.toy_story), imagen = R.drawable.toy_story))
        return peliculas
    }


}
