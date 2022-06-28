package com.example.libretacomunicaciones

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.libretacomunicaciones.controllers.AuthController
import com.example.libretacomunicaciones.utils.TilValidator
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val btnToHome= findViewById<Button>(R.id.activity_login_btn_home)
        val tvToRecoveryPassword = findViewById<TextView>(R.id.activity_login_tv_recovery_password)
       val tilEmail = findViewById<TextInputLayout>(R.id.activity_login_til_correo)
        val tilPassword = findViewById<TextInputLayout>(R.id.activity_login_til_password)
       val btnLogin = findViewById<Button>(R.id.activity_login_btn_login)


        btnToHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)


        }
        tvToRecoveryPassword.setOnClickListener {
            val intent = Intent(this, activity_recovery::class.java)

            startActivity(intent)


        }
       btnLogin.setOnClickListener {
           val email = tilEmail.editText?.text.toString()
           val password = tilPassword.editText?.text.toString()

           val emailValid = TilValidator(tilEmail)
               .required()
               .email()
               .isValid()

           val passwordValid = TilValidator(tilPassword)
               .required().validatePassword()

           if (emailValid &&passwordValid) {
               AuthController(this).login(email, password)

           } else {
               Toast.makeText(this, "Campos inválidos", Toast.LENGTH_SHORT).show()



           }
       }



    }
}