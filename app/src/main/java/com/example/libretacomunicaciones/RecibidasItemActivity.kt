package com.example.libretacomunicaciones

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import com.example.libretacomunicaciones.Models.Recibida
import com.example.libretacomunicaciones.controllers.RecibidaController
import com.example.libretacomunicaciones.ui.RecibidaAdapter

class RecibidasItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recibidas_item)

        //val recibida = intent.getSerializableExtra("recibida")
        val recibida = intent.getSerializableExtra("recibida") as Recibida

        val tvTitle = findViewById<TextView>(R.id.activity_recibidas_item_tv_title)
        //tvTitle.text=recibida.toString()
            tvTitle.text = "| Asunto: " + recibida.asunto + "| Fecha: " + recibida.fecha + "| Asignatura: " + recibida.asignatura + "" +
                    "| Estado :" + recibida.estado + "| Descripción: " + recibida.description



    }
        }







