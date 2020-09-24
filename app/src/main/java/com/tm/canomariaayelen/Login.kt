package com.tm.canomariaayelen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.inicio_sesion.*

class Login:  AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.inicio_sesion)

        button.setOnClickListener {
            var i: Intent = Intent (this,MainApp::class.java)
            startActivity(i)
        }

    }
}