package com.example.libretacomunicaciones

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import com.example.libretacomunicaciones.controllers.RecibidaController
import com.example.libretacomunicaciones.ui.RecibidaAdapter

class activity_recibidas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recibidas)

        val lvRecibidas = findViewById<ListView>(R.id.activity_lv_recibidas)
        val allRecibidas = RecibidaController(this).getAll()
        val adapter = RecibidaAdapter(this, allRecibidas)


        lvRecibidas.adapter = adapter
        lvRecibidas.setOnItemClickListener{ AdapterView,view,i,l ->
            run {
                val recibida = allRecibidas[i]
                val intent = Intent(view.context, RecibidasItemActivity::class.java)
                intent.putExtra("recibida", recibida)
                view.context.startActivity(intent)


            }
        }
    }
}

