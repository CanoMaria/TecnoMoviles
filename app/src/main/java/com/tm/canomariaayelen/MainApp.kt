package com.tm.canomariaayelen;

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainApp: AppCompatActivity(){
        var peliculas:ArrayList<Pelicula>?=null
        var lista:RecyclerView?= null
        var layoutManager:RecyclerView.LayoutManager?=null
        var adaptador:AdaptadorCustom?= null

        override fun onCreate(savedInstanceState: Bundle?){
                super.onCreate(savedInstanceState)
                setContentView(R.layout.main)

                peliculas=ArrayList()
                peliculas?.add(Pelicula(nombre = "Mulan", imagen = R.drawable.mulan))
                peliculas?.add(Pelicula(nombre = "Mulan", imagen = R.drawable.mulan))
                peliculas?.add(Pelicula(nombre = "Mulan", imagen = R.drawable.mulan))
                peliculas?.add(Pelicula(nombre = "Mulan", imagen = R.drawable.mulan))
                peliculas?.add(Pelicula(nombre = "Mulan", imagen = R.drawable.mulan))
                peliculas?.add(Pelicula(nombre = "Mulan", imagen = R.drawable.mulan))
                peliculas?.add(Pelicula(nombre = "Mulan", imagen = R.drawable.mulan))
                peliculas?.add(Pelicula(nombre = "Mulan", imagen = R.drawable.mulan))

                lista= findViewById(R.id.lista)
                layoutManager=LinearLayoutManager(this)
                adaptador = AdaptadorCustom(peliculas!!)
                lista?.layoutManager=layoutManager
                lista?.adapter=adaptador
        }


}
