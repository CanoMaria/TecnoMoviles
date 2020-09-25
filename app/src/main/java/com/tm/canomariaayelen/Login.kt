package com.tm.canomariaayelen

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Login:  AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.inicio_sesion)

        var loginButton = findViewById<Button>(R.id.button)

        loginButton.setOnClickListener(View.OnClickListener {
            startActivity( Intent(this@Login,MainApp::class.java)
            )
        })

    }
}