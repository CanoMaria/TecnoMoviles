package com.tm.canomariaayelen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tm.canomariaayelen.R.*
import com.tm.canomariaayelen.model.Pelicula


class Adapter(val data: List<Pelicula>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder=
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.peliculas,parent,false))


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val pelicula: Pelicula = data.get(position)
        holder.nombre.text= pelicula.titulo
        val url = "https://image.tmdb.org/t/p/w500"+ pelicula.poster
        Glide.with(holder.itemView.getContext()).load(url).into(holder.imagen);

    }
    override fun getItemCount(): Int {
        return data.size
    }

    //----Construcuro de mi clase---------constructor de la clase super
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val nombre = itemView.findViewById<TextView>(R.id.nomPeli)
        val imagen = itemView.findViewById<ImageView>(R.id.imagePeli)  //encuentro dentro de la vista por id la imagen
    }

}


/*class Adapter(val context: Context, val data: List<Pelicula>) : BaseAdapter(){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
      val view : View = LayoutInflater.from(context).inflate(layout.peliculas,parent,false)
      val titulo = view.findViewById(R.id.nomPeli) as TextView
        titulo.text=data[position].titulo.toString()
        return view
    }

    override fun getItem(position: Int): Any {
        return data[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return data.size
    }

}*/