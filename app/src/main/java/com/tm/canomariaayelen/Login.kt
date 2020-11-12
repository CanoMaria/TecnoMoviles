package com.tm.canomariaayelen


import android.app.AlertDialog
import android.content.ContentValues
import android.content.DialogInterface

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tm.canomariaayelen.persistence.MyDBHeleper
import kotlinx.android.synthetic.main.fragm_registro.*

class Login:  AppCompatActivity(), OnFragmentActionsListener {

    val manager= supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activ_inicio_sesion)

        var loginButton = findViewById<Button>(R.id.loginbutton)
        loginButton.setOnClickListener(View.OnClickListener {
            startActivity( Intent(this@Login,MainApp::class.java)
            )
        })

        var registerButton = findViewById<Button>(R.id.registerbutton)
        registerButton.setOnClickListener({showFragmentRegister()})

    }

    fun showFragmentRegister(){
        val transaction= manager.beginTransaction()
        val fragment= FragmenteRegister(applicationContext)
        transaction.replace(R.id.fragment_registro,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


    fun loadDB(){

        var helper= MyDBHeleper(applicationContext)
        var db= helper.readableDatabase




        if(validaciones()==false){
            val args=listOf<String>(email.text.toString()).toTypedArray()
            var rs= db.rawQuery("SELECT * FROM USERS WHERE EMAIL=?",args)
            if(rs.moveToNext()){
                Toast.makeText(applicationContext,"el usuario ya esta registrado", Toast.LENGTH_LONG).show()
            }

            var cv = ContentValues()
            cv.put("NAME",nombre.text.toString())
            cv.put("USER",user.text.toString())
            cv.put("PASSWORD",contraseñaI.text.toString())
            cv.put("EMAIL",email.text.toString())
            db.insert("USERS",null,cv)

            findViewById<TextView>(R.id.nombre).setText("")
            findViewById<TextView>(R.id.user).setText("")
            findViewById<TextView>(R.id.contraseñaI).setText("")
            findViewById<TextView>(R.id.contraseñaII).setText("")
            findViewById<TextView>(R.id.nombre).requestFocus()
        }

    }

    override fun onClickFragmentButton() {
        loadDB()
    }

    fun validaciones(): Boolean {
        var error=false
        var nombre=findViewById<TextView>(R.id.nombre).text.toString()
        var user= findViewById<TextView>(R.id.user).text.toString()
        var email= findViewById<TextView>(R.id.email).text.toString()
        var pass1=findViewById<TextView>(R.id.contraseñaI).text.toString()
        var pass2=findViewById<TextView>(R.id.contraseñaII).text.toString()

        if(nombre.equals("") || user.equals("") || email.equals("") || pass1.equals("") || pass2.equals(""))
        {
            error=true
            alertaCamposVacios()
        }
        if(pass1!=pass2){
            error=true
            findViewById<TextView>(R.id.contraseñaI).setError("Las constraseñas no coinciden")
            findViewById<TextView>(R.id.contraseñaII).setError("Las constraseñas no coinciden")
        }
        Toast.makeText(applicationContext,"valido", Toast.LENGTH_LONG).show()
        return error
    }
    fun alertaCamposVacios(){

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Atencion")
        builder.setMessage("Todos los campos deben estar completos")
        builder.setPositiveButton("Aceptar"){
                dialogInterface : DialogInterface, i :Int ->
        }
        builder.show()
    }


}