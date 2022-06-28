package com.example.libretacomunicaciones.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.libretacomunicaciones.Models.Recibida
import com.example.libretacomunicaciones.R

// Adaptamos los datos recibidos de la lista para crear un inflate de las notificaciones recibidas
class RecibidaAdapter (private val ctx: Context, private val recibidas: List<Recibida>): BaseAdapter(){

    override fun getCount(): Int {
        return recibidas.size
    }

    override fun getItem(i: Int): Recibida {
        return recibidas[i]
    }

    override fun getItemId(i: Int): Long {
        return recibidas[i].id!!
    }

    override fun getView(i: Int, view: View?, viewGroup: ViewGroup?): View {
        val inflater = LayoutInflater.from(ctx)

        val rowView = inflater.inflate(R.layout.item_recibida, null )

        val recibida = recibidas[i]

        val tvTitle = rowView.findViewById<TextView>(R.id.item_recibida_tv_title)

        tvTitle.text = recibida.asignatura + ": "+ recibida.asunto

        return rowView
    }


}