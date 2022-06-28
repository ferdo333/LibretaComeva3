package com.example.libretacomunicaciones.Models

import java.util.*

data class User(

    val id: Long?,
    val nombre: String,
    val ap_alumno: String,
    val email: String,
    val password: String,
    val rpassword: String,
    val birth: Date,
    val curso: String
)
