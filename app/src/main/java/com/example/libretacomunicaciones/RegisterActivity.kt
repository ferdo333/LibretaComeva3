package com.example.libretacomunicaciones

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.libretacomunicaciones.Models.User
import com.example.libretacomunicaciones.controllers.AuthController
import com.example.libretacomunicaciones.utils.TilValidator
import com.example.libretacomunicaciones.utils.showDatePickerDialog
import com.google.android.material.textfield.TextInputLayout
import java.text.SimpleDateFormat
import java.util.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        val btnHome = findViewById<Button>(R.id.activity_register_btn_home)
        val tilLogin = findViewById<TextView>(R.id.activity_register_til_login)
        val btnRegistrar = findViewById<Button>(R.id.activity_register_btn_register)
        val tilNombre = findViewById<TextInputLayout>(R.id.activity_register_til_nombre)
        val tilApellido = findViewById<TextInputLayout>(R.id.activity_register_til_ap_alumno)
       // val tilBirth= findViewById<TextInputLayout>(R.id.activity_register_til_birth)
        val tilBirth = findViewById<TextInputLayout>(R.id.activity_register_til_birth)
        val tilEmail = findViewById<TextInputLayout>(R.id.activity_register_til_email)
       val spnCurso = findViewById<Spinner>(R.id.activity_register_spn_curso)
        val tilPassword = findViewById<TextInputLayout>(R.id.activity_register_til_password)
        val tilRepeatPassword = findViewById<TextInputLayout>(R.id.activity_register_til_repeat_password)

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.curso_array,
            android.R.layout.simple_spinner_item
        )


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spnCurso.adapter = adapter

        tilBirth.editText?.setOnClickListener { _ ->
            showDatePickerDialog(this, tilBirth, Date())
        }






        btnHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)

        }

        tilLogin.setOnClickListener {
            val intent = Intent(this,LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }

        btnRegistrar.setOnClickListener {
            val nombre = tilNombre.editText?.text.toString()
            val ap_alumno = tilApellido.editText?.text.toString()
            val email = tilEmail.editText?.text.toString()
            val password = tilPassword.editText?.text.toString()
            val rpassword = tilRepeatPassword.editText?.text.toString()
            val birth = tilBirth.editText?.text.toString()
            val curso = spnCurso.selectedItem.toString()

            val nombreValid = TilValidator(tilNombre)
                .required()
                .name()
                .isValid()
            val ApValid = TilValidator(tilApellido)
                .required()
                .name()
                .isValid()
            val birthValid = TilValidator(tilBirth)
                .required()
                .dateBefore(Date())
                .isValid()

            val emailValid = TilValidator(tilEmail)
                .required()
                .email()
                .isValid()
            val passwordValid = TilValidator(tilPassword)
                .required().validatePassword()
           // val rPassValid = TilValidator(tilRepeatPassword).required().rPass()

            if (nombreValid&&ApValid&&birthValid&&emailValid&&passwordValid) {
                val user = User(
                    id = null,
                    nombre = nombre,
                    ap_alumno = ap_alumno,
                    email = email,
                    password = password,
                    rpassword = rpassword,
                    birth = SimpleDateFormat("yyyy-MM-dd").parse(birth),
                    curso = curso
                )

                AuthController(this).register(user)
               // val intent = Intent(this, activity_indx::class.java)

                //startActivity(intent)
            } else {
                Toast.makeText(this, "Campos inválidos", Toast.LENGTH_SHORT).show()



            }
        }


    }


}