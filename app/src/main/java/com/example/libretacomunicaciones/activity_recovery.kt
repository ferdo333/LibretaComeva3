package com.example.libretacomunicaciones

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.libretacomunicaciones.utils.TilValidator
import com.google.android.material.textfield.TextInputLayout

class activity_recovery : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recovery)

        val btnHome = findViewById<Button>(R.id.activity_recovery_password_btn_home)
        val tvLogin = findViewById<TextView>(R.id.activity_recovery_password_tv_login)
        val btnRecoveryPassword = findViewById<Button>(R.id.activity_recovery_password_btn_recuperar)
        val tilEmail = findViewById<TextInputLayout>(R.id.activity_recovery_password_til_correo)
        tvLogin.setOnClickListener {
             val intent = Intent(this, LoginActivity::class.java)

             startActivity(intent)
         }

        btnHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }
         btnRecoveryPassword.setOnClickListener {
             val email = tilEmail.editText?.text
             val emailValid = TilValidator(tilEmail)
                 .required()
                 .email()
                 .isValid()

            // Toast.makeText(this, emailValid.toString(), Toast.LENGTH_LONG ).show()
         }
    }
}