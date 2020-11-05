package com.tm.canomariaayelen

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Login:  AppCompatActivity() {

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
        val fragment= FragmenteRegister()
        transaction.replace(R.id.fragment_registro,fragment)
        transaction.addToBackStack(null)
        transaction.commit()

    }
}