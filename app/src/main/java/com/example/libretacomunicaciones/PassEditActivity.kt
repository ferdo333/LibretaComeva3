package com.example.libretacomunicaciones

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.libretacomunicaciones.utils.TilValidator
import com.google.android.material.textfield.TextInputLayout

class PassEditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pass_edit)

        val btnEdit= findViewById<Button>(R.id.activity_edit_pass_btn_edit)
        val btnBack= findViewById<Button>(R.id.activity_edit_pass_btn_to_index)
        val tilPassword = findViewById<TextInputLayout>(R.id.activity_edit_pass_til_password)
        val tilRepeatPassword = findViewById<TextInputLayout>(R.id.activity_edit_pass_til_rPassword)
        btnBack.setOnClickListener {
            val intent = Intent(this, activity_indx::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)


        }
        btnEdit.setOnClickListener {
            val passwordValid = TilValidator(tilPassword)
                .required().validatePassword()
            val rPasswordValid = TilValidator(tilRepeatPassword)
                .rPass()

            if (passwordValid&&rPasswordValid) {
                Toast.makeText(this, "CONTRASEÑA EDITADA CORRECTAMENTE", Toast.LENGTH_LONG).show()
                val intent = Intent(this, activity_indx::class.java)

                startActivity(intent)
            } else {
                Toast.makeText(this, "Campos inválidos", Toast.LENGTH_SHORT).show()



            }
        }
    }
}