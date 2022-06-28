package com.example.libretacomunicaciones.controllers

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.room.Room
import com.example.libretacomunicaciones.MainActivity
import com.example.libretacomunicaciones.Models.Recibida
import com.example.libretacomunicaciones.Models.RecibidaEntity
import com.example.libretacomunicaciones.activity_indx
import com.example.libretacomunicaciones.lib.AppDatabase

class RecibidaController constructor(ctx: Context, userId: Long = 0){
    private val ctx = ctx
    private val sharedPref = ctx.getSharedPreferences("LIBRETA_APP", Context.MODE_PRIVATE)
    private val userId = userId
    private val dao = Room.databaseBuilder(
        ctx,
        AppDatabase::class.java, "database-name"

    )
        .allowMainThreadQueries()
        .build()
        .recibidasDao()

    fun getAll ():List<Recibida>{
        val recibidaEntity = dao.findAll(userId)
        val recibidas = ArrayList<Recibida>()


        recibidaEntity.forEach{recibida -> recibidas.add(Recibida(
            id = recibida.id,
            asunto=recibida.asunto,
            fecha= recibida.fecha,
            asignatura=recibida.asignatura,
            description=recibida.description,
            estado=recibida.estado,
            done=recibida.done
        ))}
        return recibidas
    }

    fun getById(id: Long): Recibida? {
        val entity = dao.findById(id) ?: return null

        return Recibida(
            id = entity?.id,
            asunto=entity.asunto,
            fecha= entity.fecha,
            asignatura=entity.asignatura,
            description=entity.description,
            estado=entity?.estado,
            done=entity.done
        )
    }

    fun create (recibida: Recibida) {
        val entity = RecibidaEntity(
            id = null,
            asunto=recibida.asunto,
            fecha= recibida.fecha,
            asignatura=recibida.asignatura,
            description=recibida.description,
            estado=recibida.estado,
            done=recibida.done,
            userId = sharedPref.getLong("user_id", -1)
        )
        dao.insert(entity)

        val intent = Intent(ctx, activity_indx::class.java)
        ctx.startActivity(intent)
        (this.ctx as Activity).finish()
    }

    fun update (recibida: Recibida) {
        val entity = RecibidaEntity(
            id = null,
            asunto=recibida.asunto,
            fecha= recibida.fecha,
            asignatura=recibida.asignatura,
            description=recibida.description,
            estado=recibida.estado,
            done=recibida.done,
            userId = sharedPref.getLong("user_id", -1)
        )
        dao.update(entity)

        val intent = Intent(ctx, activity_indx::class.java)
        ctx.startActivity(intent)
        (this.ctx as Activity).finish()
    }

    fun delete (recibida: Recibida) {
        val entity = RecibidaEntity(
            id = null,
            asunto=recibida.asunto,
            fecha= recibida.fecha,
            asignatura=recibida.asignatura,
            description=recibida.description,
            estado=recibida.estado,
            done=recibida.done,
            userId = sharedPref.getLong("user_id", -1)
        )
        dao.delete(userId)

        val intent = Intent(ctx, activity_indx::class.java)
        ctx.startActivity(intent)
        (this.ctx as Activity).finish()
    }





}
// aquí rellenaos el arreglo para poder mostras ejemplo
/* recibidas.add(Recibida(1,"prueba lenguaje","dd/mm/aa", "Lenguaje", "" +
"Estimado: revise la fecha de su prueba.", "No leído"))

recibidas.add(Recibida(2,"actividad atrasada","dd/mm/aa", "Matemática", "" +
"Estimado: Tiene una actividad vencida.","Leído"))

recibidas.add(Recibida(3,"Citación de apoderado","dd/mm/aa", "Consejo de curso","" +
"Estimado Apoderado: Esta citado por que su pupilo cometió un error gravisimo.", "Firmado"))

recibidas.add(Recibida(4,"Exposición evaluada","dd/mm/aa", "Historia" ,"" +
"Estimado Alumno: Su exposición fue evaluada con un 3,5", "Leído"))


recibidas.add(Recibida(5,"Exposición evaluada","dd/mm/aa", "Historia" ,"" +
"Estimado Alumno: Su exposición fue evaluada con un 3,5", "Leído"))


recibidas.add(Recibida(6,"Citación de apoderado","dd/mm/aa", "Consejo de curso","" +
"Estimado Apoderado: Esta citado por que su pupilo cometió un error gravisimo.", "Firmado"))

recibidas.add(Recibida(7,"prueba lenguaje","dd/mm/aa", "Lenguaje", "" +
"Estimado: revise la fecha de su prueba.", "No leído"))

recibidas.add(Recibida(8,"actividad atrasada","dd/mm/aa", "Matemática", "" +
"Estimado: Tiene una actividad vencida.","Leído"))

recibidas.add(Recibida(9,"Exposición evaluada","dd/mm/aa", "Historia" ,"" +
"Estimado Alumno: Su exposición fue evaluada con un 3,5", "Leído"))


recibidas.add(Recibida(10,"Citación de apoderado","dd/mm/aa", "Consejo de curso","" +
"Estimado Apoderado: Esta citado por que su pupilo cometió un error gravisimo.", "Firmado"))

recibidas.add(Recibida(11,"prueba lenguaje","dd/mm/aa", "Lenguaje", "" +
"Estimado: revise la fecha de su prueba.", "No leído"))

recibidas.add(Recibida(12,"actividad atrasada","dd/mm/aa", "Matemática", "" +
"Estimado: Tiene una actividad vencida.","Leído"))*/
