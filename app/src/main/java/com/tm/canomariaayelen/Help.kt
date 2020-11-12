package com.tm.canomariaayelen

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activ_help.*

class Help : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activ_help)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayShowTitleEnabled(false)
        enviarCorreo.setOnClickListener{
            val nombre = remitente.text.toString()
            val asunto = asunto.text.toString()
            val mensaje = mensaje.text.toString()
            sendEmail(nombre,asunto,mensaje)
        }

    }

    private fun sendEmail(nombre: String, asunto: String, mensaje: String) {
        val mIntent = Intent(Intent.ACTION_SEND)
        mIntent.data= Uri.parse("mailto:")
        mIntent.type= "text/plain"
        mIntent.putExtra(Intent.EXTRA_EMAIL,"ayecano98@gmail.com")
        mIntent.putExtra(Intent.EXTRA_SUBJECT,asunto)
        mIntent.putExtra(Intent.EXTRA_TEXT,mensaje)

        try {
            startActivity(Intent.createChooser(mIntent,"Escoje Email"))
        }catch (e: Exception){
            Toast.makeText(this,e.message,Toast.LENGTH_LONG).show()
        }
    }


}