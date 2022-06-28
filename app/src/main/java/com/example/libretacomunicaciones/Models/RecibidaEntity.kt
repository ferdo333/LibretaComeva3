package com.example.libretacomunicaciones.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recibidas")
data class RecibidaEntity(
    @PrimaryKey(autoGenerate = true) val id: Long?,
    val asunto: String,
    val fecha: String,
    val asignatura: String,
    val description: String,
    val estado: String?,
    val done: Boolean=false,
    @ColumnInfo(name ="user_id") val userId: Long
)
