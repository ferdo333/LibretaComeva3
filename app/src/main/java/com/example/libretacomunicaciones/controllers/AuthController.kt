package com.example.libretacomunicaciones.controllers


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.room.Room
import com.example.libretacomunicaciones.LoginActivity
import com.example.libretacomunicaciones.Models.User
import com.example.libretacomunicaciones.Models.UserEntity
import com.example.libretacomunicaciones.activity_indx
import com.example.libretacomunicaciones.lib.AppDatabase
import com.example.libretacomunicaciones.lib.BCrypt
import java.text.SimpleDateFormat


class AuthController constructor(ctx: Context) {
    private val sharedPref = (ctx as Activity).getPreferences(Context.MODE_PRIVATE)
    private val INCORRECT_CREDENTIALS = "Credenciales incorrectas"
    private val ctx = ctx
    private val dao = Room.databaseBuilder(
        ctx,
        AppDatabase::class.java, "database-name"

    )
        .allowMainThreadQueries()
        .fallbackToDestructiveMigration()
        .build()
        .userDao()




    fun login(email: String, password: String) {
        val user = dao.findByEmail(email)
        if (user==null){
            Toast.makeText(this.ctx, INCORRECT_CREDENTIALS, Toast.LENGTH_LONG).show()
            return
        }

        if (BCrypt.checkpw(password, user.password)) {
            Toast.makeText(this.ctx, "Bienvenido ${user.nombre}", Toast.LENGTH_LONG).show()
            val sharedEdit = sharedPref.edit()
            sharedEdit.putLong("user_id", user.id!!)
            sharedEdit.apply()
            val intent = Intent(this.ctx, activity_indx::class.java)
            this.ctx.startActivity(intent)

        } else {
            Toast.makeText(this.ctx, INCORRECT_CREDENTIALS, Toast.LENGTH_LONG).show()
            val intent = Intent(this.ctx, LoginActivity::class.java)
            this.ctx.startActivity(intent)
        }
    }

    fun register(user: User) {
        val hashedPassword = BCrypt.hashpw(user.password, BCrypt.gensalt())
        val hashedRPassword = BCrypt.hashpw(user.rpassword, BCrypt.gensalt())
        val userEntity = UserEntity(
            id = null,
            nombre = user.nombre,
            ap_alumno = user.ap_alumno,
            email = user.email,
            password = hashedPassword,
            rpassword = hashedRPassword,
            birth = user.birth,
            curso = user.curso
        )


        try {
            dao.insert(userEntity)


            Toast.makeText(this.ctx, "Cuenta registrada", Toast.LENGTH_SHORT).show()
            val intent = Intent(this.ctx, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            this.ctx.startActivity(intent)
        }catch (e: Exception){
            Toast.makeText(this.ctx, "Cuenta Existente", Toast.LENGTH_SHORT).show()
        }




    }




}
