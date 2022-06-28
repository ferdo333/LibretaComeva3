package com.example.libretacomunicaciones.utils

import android.util.Patterns
import android.widget.Spinner
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Pattern

class TilValidator constructor(til: TextInputLayout ){
    private val formatter = SimpleDateFormat("yyyy-MM-dd")
    private val til: TextInputLayout = til
    private val value: String = til.editText?.text.toString()
    private var required: Boolean = false
    private var invalid: Boolean = false
    private val password: String = til.editText?.text.toString()
    private val rpassword: String = til.editText?.text.toString()
    private val name: String = til.editText?.text.toString()



    private val message: String = til.editText?.text.toString()

    private fun setError(invalid: Boolean, message: String){
        if (invalid){
            this.invalid = true
            til.error = message
        }else{
            til.error = null
            til.isErrorEnabled = false
        }

    }
    private fun mustValidate(): Boolean{
        return (!this.required && this.value.isNotEmpty() || !invalid)
    }
    public fun required(): TilValidator{
        this.required = true
        val invalidField = this.value.isEmpty()
        this.setError(invalidField, "CAMPO REQUERIDO")
        return this
    }
    fun email(): TilValidator{
        if (mustValidate()){
            val invalidField = !Patterns.EMAIL_ADDRESS.matcher(this.value).matches()
            this.setError(invalidField, "DEBE INGRESAR EMAIL VALIDO")
        }
        return this
    }
    fun name(): TilValidator{

            val limitRegex = Pattern.compile(
                "^" +
                        "(?=.*[a-zA-Z])" +        //at least 1 lower case letter
                        "(?=\\S+$)" +           //no white spaces
                        ".{4,20}" +               //at least 4 characters
                        "$"
            )
        if (mustValidate()){
            val invalidField = !limitRegex.matcher(this.name).matches()
            this.setError(invalidField, "FORMATO INVALIDO: debe contener entre 4 y 20" +
                    " caracteres. Sin numeros. Sin espacios en blancos.")
        }
        return this

    }

    fun rPass():Boolean{
        if (mustValidate()){
            val invalidField = password != rpassword
            this.setError(invalidField, "CONTRASEÑAS NO COINCIDEN")
            return false
        }else (return true)


    }
    fun maxMessage(): TilValidator{

        val limitRegex = Pattern.compile(
            "^" +
                    "(?=.*[a-zA-Z])" +        //at least 1 lower case letter
                    "(?=\\S+$)" +           //no white spaces
                    ".{1,500}" +               //at least 4 characters
                    "$"
        )
        if (mustValidate()){
            val invalidField = !limitRegex.matcher(this.message).matches()
            this.setError(invalidField, "ERROR: EL MENSAJE DEBE CONTENER ENTRE" +
                    "1 Y 300 CARACTERES")
        }
        return this

    }



       fun validatePassword(): Boolean{

        val passwordRegex = Pattern.compile(
            "^" +
                    "(?=.*[0-9])" +         //at least 1 digit
                    "(?=.*[a-z])" +        //at least 1 lower case letter
                    "(?=.*[A-Z])" +        //at least 1 upper case letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{4,12}" +               //at least 4 characters
                    "$"
        )
        return if (this.password.isEmpty()){
            val invalidField = this.password.isEmpty()
            this.setError(invalidField, "CAMPO NO DEBE ESTAR VACIO")
            false
        }else if (!passwordRegex.matcher(this.password).matches()){

            setError(true,"CONTRSEÑA DEBIL: debe contener entre 4 y 12 caracteres," +
                    "al menos 1 minuscula, 1 mayuscula, un caracter especial (@#$/%^&+=..)." +
                    "sin espacios en blanco")
            false
        }else{

            true
        }
    }
     fun validate(){
        val result = arrayOf(validatePassword())

        if (false in result){
            return
        }


    }




    fun dateAfter(date: Date): TilValidator {
        if (mustValidate()) {
            var invalidField = false
            try {
                val dateValue = formatter.parse(this.value)
                invalidField = !dateValue.after(date)
            } catch (e: Exception) {
                invalidField = true
            }
            this.setError(invalidField, "La fecha no puede ser anterior a ${formatter.format(date)}")
        }
        return this
    }

    fun dateBefore(date: Date): TilValidator {
        if (mustValidate()) {
            var invalidField = false
            try {
                val dateValue = formatter.parse(this.value)
                invalidField = !dateValue.before(date)
            } catch (e: Exception) {
                invalidField = true
            }
            this.setError(invalidField, "La fecha no puede ser posterior a ${formatter.format(date)}")
        }
        return this
    }




    fun isValid(): Boolean{
        return !this.invalid
    }
}


