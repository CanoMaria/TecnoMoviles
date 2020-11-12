package com.tm.canomariaayelen;

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tm.canomariaayelen.appi.IPeliculaService
import com.tm.canomariaayelen.model.Objeto
import com.tm.canomariaayelen.model.Pelicula
import dev.bensalcie.retrofitest.services.ServiceBuilder
import kotlinx.android.synthetic.main.activ_main.*
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.HttpURLConnection
import java.net.URL
import java.util.*
import kotlin.collections.ArrayList


class MainApp: AppCompatActivity() {
        val context = this
           override fun onCreate(savedInstanceState: Bundle?){
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activ_main)

           // val url = "https://api.themoviedb.org/3/discover/movie?api_key=32032564978a1c288fa5874397c2a0bf"
           // AsyncTaskHandleJson().execute(url)

               loadPeliculas()
        }

    private fun loadPeliculas() {
        //initiate the service
        val destinationService  = ServiceBuilder.buildService(IPeliculaService ::class.java)
        val requestCall =destinationService.obtenerLista()

        //make network call asynchronously
        requestCall.enqueue(object : Callback<Objeto>{
            override fun onResponse(call: Call<Objeto>, response: Response<Objeto>) {
                Log.d("Response", "onResponse: ${response.body()}")
                if (response.isSuccessful){
                    val peliculas  = response.body().items
                    Log.d("Response", "TODO OKEEY : ${peliculas}")
                    lista.apply {
                        layoutManager = GridLayoutManager(this@MainApp,2)
                        adapter = Adapter(peliculas)
                    }
                }else{
                    Toast.makeText(this@MainApp, "TODO MAL ${response.message()}", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<Objeto>, t: Throwable) {
                Toast.makeText(this@MainApp, "TODO MAL $t", Toast.LENGTH_SHORT).show()
            }
        })
    }

 /*


  private fun cargarPelis(): List<Pelicula> {
       peliculas.add(
           Pelicula(
               nombre = getString(R.string.mulan),
               imagen = R.drawable.mulan
           )
       )
       peliculas.add(
           Pelicula(
               nombre = getString(R.string.cab_zodiaco),
               imagen = R.drawable.caballeros_zodiaco
           )
       )
       peliculas.add(
           Pelicula(
               nombre = getString(R.string.rey_leon),
               imagen = R.drawable.rey_leon
           )
       )
       peliculas.add(
           Pelicula(
               nombre = getString(R.string.dragon_ball),
               imagen = R.drawable.dragon_ball
           )
       )
       peliculas.add(
           Pelicula(
               nombre = getString(R.string.sailor_moon),
               imagen = R.drawable.sailor_moon
           )
       )
       peliculas.add(
           Pelicula(
               nombre = getString(R.string.toy_story),
               imagen = R.drawable.toy_story
           )
       )
       return peliculas
   }*/


}



/*class AsyncTaskHandleJson() : AsyncTask<String, String, String>() {


    override fun doInBackground(vararg url: String?): String {
       var text: String
       val connection = URL(url[0]).openConnection() as HttpURLConnection
        try{
            connection.connect()
            text = connection.inputStream.use{it.reader().use{reader-> reader.readText()}}
        }finally {
            connection.disconnect()
        }
        return text
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
        handleJson(result)
    }

    private fun handleJson(jsonString: String?) {
        val jsonArray =JSONArray(jsonString)
        val peliculas = ArrayList<Pelicula>()
        var x=0
        while(x< 10){
            val jsonObject = jsonArray.getJSONObject(x)
            peliculas.add(Pelicula(
                jsonObject.getInt("cant_votos"),
                jsonObject.getDouble("popularidad"),
                jsonObject.getInt("id"),
                jsonObject.getBoolean("video"),
                jsonObject.getString("tipo"),
                jsonObject.getDouble("puntuacion"),
                jsonObject.getString("titulo"),
                jsonObject.getString("año"),
                jsonObject.getString("lenguaje"),
                jsonObject.getString("titulo_original"),
                jsonObject.getString("id_generos"),
                jsonObject.getString("backdrop"),
                jsonObject.getBoolean("adulto"),
                jsonObject.getString("descipcion"),
                jsonObject.getString("poster")
            ))
            x++
        }
        val adapter = Adapter(this,peliculas)
    }
}*/




