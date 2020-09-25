package com.tm.canomariaayelen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.peliculas.view.*

class Adapter(val data : List<Pelicula>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder=
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.peliculas,parent,false))


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val pelicula:Pelicula = data.get(position)
        holder.nombre.text= pelicula.nombre
        holder.imagen.setImageResource(pelicula.imagen)
    }
    override fun getItemCount(): Int {
        return data.size
    }

    //----Construcuro de mi clase---------constructor de la clase super
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imagen = itemView.findViewById<ImageView>(R.id.imagePeli)  //encuentro dentro de la vista por id la imagen
        val nombre = itemView.findViewById<TextView>(R.id.nomPeli)
    }

}

