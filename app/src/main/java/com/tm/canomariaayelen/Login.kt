package com.tm.canomariaayelen


import android.app.AlertDialog
import android.content.ContentValues
import android.content.DialogInterface

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tm.canomariaayelen.persistence.MyDBHeleper
import kotlinx.android.synthetic.main.activ_inicio_sesion.*
import kotlinx.android.synthetic.main.fragm_registro.*

class Login:  AppCompatActivity(), OnFragmentActionsListener {

    val manager= supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activ_inicio_sesion)

        var loginButton = findViewById<Button>(R.id.loginbutton)
        loginButton.setOnClickListener(View.OnClickListener { validarInicio() })

        var registerButton = findViewById<Button>(R.id.registerbutton)
        registerButton.setOnClickListener({showFragmentRegister()})

    }


    fun validarInicio(){
        var db= connectBD()
        if(editTextUser.text.toString().equals("")|| editTextPassword.text.toString().equals(""))
        {
            alerta("Todos los campos deben estar completos")
        }else{
            val args=listOf<String>(editTextUser.text.toString(),editTextPassword.text.toString()).toTypedArray()
            var rs= db?.rawQuery("SELECT * FROM USERS WHERE USER=? or PASSWORD=?",args)
            if(rs?.moveToNext()!!){
                findViewById<TextView>(R.id.editTextUser).setText("")
                findViewById<TextView>(R.id.editTextPassword).setText("")

                startActivity( Intent(this@Login,MainApp::class.java))
                Toast.makeText(applicationContext,"Bienvenido", Toast.LENGTH_LONG).show()
            }else{
                alerta("Usuario o contraseña incorrectos")
            }
        }
    }

    fun showFragmentRegister(){
        val transaction= manager.beginTransaction()
        val fragment= FragmenteRegister(applicationContext)
        transaction.replace(R.id.fragment_registro,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
     fun connectBD(): SQLiteDatabase? {
         var helper= MyDBHeleper(applicationContext)
         var db= helper.readableDatabase
         return db
     }
    fun guardarUserDB(){

       var db= connectBD()

        if(validaciones()==false){
            val args=listOf<String>(email.text.toString(),user.text.toString()).toTypedArray()
            var rs= db?.rawQuery("SELECT * FROM USERS WHERE EMAIL=? or USER=?",args)
            if(rs!!.moveToNext()){
                alerta("El usuario ya se encuentra registrado")
            }

            var cv = ContentValues()
            cv.put("NAME",nombre.text.toString())
            cv.put("USER",user.text.toString())
            cv.put("PASSWORD",contraseñaI.text.toString())
            cv.put("EMAIL",email.text.toString())
            db?.insert("USERS",null,cv)

            findViewById<TextView>(R.id.nombre).setText("")
            findViewById<TextView>(R.id.user).setText("")
            findViewById<TextView>(R.id.contraseñaI).setText("")
            findViewById<TextView>(R.id.contraseñaII).setText("")
            findViewById<TextView>(R.id.email).setText("")
            findViewById<TextView>(R.id.nombre).requestFocus()
        }

    }

    override fun onClickFragmentButton() {
        guardarUserDB()
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
            alerta("Todos los campos deben estar completos")
        }
        if(pass1!=pass2){
            error=true
            findViewById<TextView>(R.id.contraseñaI).setError("Las constraseñas no coinciden")
            findViewById<TextView>(R.id.contraseñaII).setError("Las constraseñas no coinciden")
        }
        Toast.makeText(applicationContext,"valido", Toast.LENGTH_LONG).show()
        return error
    }
    fun alerta(mensaje:String){

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Atencion")
        builder.setMessage(mensaje)
        builder.setPositiveButton("Aceptar"){
                dialogInterface : DialogInterface, i :Int ->
        }
        builder.show()
    }


}