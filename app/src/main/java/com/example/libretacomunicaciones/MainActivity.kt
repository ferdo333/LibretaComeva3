package com.example.libretacomunicaciones

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnToLogin = findViewById<Button>(R.id.activity_main_btn_to_login)
        val btnToRegister = findViewById<Button>(R.id.activity_main_btn_to_register)
       btnToLogin.setOnClickListener {
           val intent = Intent(this, LoginActivity::class.java)
           intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
           startActivity(intent)


       }
        btnToRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)


        }

    }
}