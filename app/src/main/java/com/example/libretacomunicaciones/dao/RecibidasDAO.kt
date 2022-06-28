package com.example.libretacomunicaciones.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.libretacomunicaciones.Models.Recibida
import com.example.libretacomunicaciones.Models.RecibidaEntity
import com.example.libretacomunicaciones.Models.UserEntity

@Dao
interface RecibidasDAO {
    @Query("SELECT * FROM recibidas WHERE user_id = :userId")
    fun findAll(userId: Long): List<RecibidaEntity>

    @Query("SELECT * FROM recibidas WHERE user_id = :id")
    fun findById(id: Long): RecibidaEntity?


    @Insert
    fun insert(recibida: RecibidaEntity)

    @Update
    fun update(recibida: RecibidaEntity)

    @Query("DELETE  FROM recibidas WHERE user_id = :id")
    fun delete(id: Long)
}