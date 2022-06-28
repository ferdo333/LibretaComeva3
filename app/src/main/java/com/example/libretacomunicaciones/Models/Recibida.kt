package com.example.libretacomunicaciones.Models
import java.io.Serializable


data class Recibida(

    //Atributos de la notifi recibida
    val id: Long?,
    val asunto: String,
    val fecha: String,
    val asignatura: String,
    val description: String,
    val estado: String?,
    val done: Boolean=false



):Serializable
//Para tramsferir los datos que utilizaremos