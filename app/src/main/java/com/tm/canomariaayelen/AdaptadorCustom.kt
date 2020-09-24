package com.tm.canomariaayelen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.main.view.*

class AdaptadorCustom(items:ArrayList<Pelicula>): RecyclerView.Adapter<ViewHolder>(){
     var items :ArrayList<Pelicula>?= null
    var viewHolder:ViewHolder?=null
    init {
        this.items=items
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items?.get(position)  // ViewHolder contiene la posicion de la celda actual que se debe renderizar
        holder.nombre?.text =item?.nombre
        holder.imagen?.setImageResource(item?.imagen!!)
    }

    override fun getItemCount(): Int { //reggresa el numero de elementos que tiene mi lista de datos
        return this.items?.count()!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder { //crea una vista con el patron de diceño ViewHolder
       val vista = LayoutInflater.from(parent?.context).inflate(R.layout.main,parent,false)

        viewHolder=ViewHolder(vista)
        return viewHolder!!
    }


}
class ViewHolder(vista: View):RecyclerView.ViewHolder(vista){
    var vista = vista
    var imagen: ImageView?= null
    var nombre: TextView?= null
    init {
        imagen = vista.imagePeli
        nombre = vista.nomPeli
    }
}
