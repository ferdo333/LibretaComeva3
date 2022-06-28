package com.example.libretacomunicaciones

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class activity_indx : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_indx)
        val btnToEnd = findViewById<Button>(R.id.activity_index_btn_to_End)
        val btnToEditPass = findViewById<Button>(R.id.activity_index_btn_to_EditPassword)
        val btntoCrearNotif = findViewById<Button>(R.id.activity_index_btn_to_crear_notif)
        val btntoRecibidas = findViewById<Button>(R.id.activity_index_btn_to_recibidas)


        btnToEnd.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)


        }

        btnToEditPass.setOnClickListener {
            val intent = Intent(this, PassEditActivity::class.java)
            startActivity(intent)


        }

        btntoCrearNotif.setOnClickListener {
            val intent = Intent(this, activity_crear_notif::class.java)
            startActivity(intent)


        }

        btntoRecibidas.setOnClickListener {
            val intent = Intent(this, activity_recibidas::class.java)
            startActivity(intent)


        }
        btntoCrearNotif.setOnClickListener {
            val intent = Intent(this, activity_crear_notif::class.java)
            startActivity(intent)


        }

    }
}