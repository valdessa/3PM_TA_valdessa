package com.example.amiiboapp

import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.text.HtmlCompat

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()

        setContentView(R.layout.activity_register)

        val username : EditText = findViewById(R.id.username)
        val password : EditText = findViewById(R.id.password)
        val register : Button = findViewById(R.id.register)
        val cancel : Button = findViewById(R.id.cancel)
        val currentPreference : SharedPreferences = getSharedPreferences("UserInfo", 0)

        register.setOnClickListener() {
            val usernameValue : String = username.text.toString()
            val passwordValue : String = password.text.toString()

            if(usernameValue.length > 1){
                val currentEditor : SharedPreferences.Editor = currentPreference.edit()
                currentEditor.putString("username", usernameValue)
                currentEditor.putString("password", passwordValue)
                currentEditor.apply()
                Toast.makeText(this, HtmlCompat.fromHtml("<font color= '#228B22'> <b>" +
                        "USER REGISTERED :D" + "</b></font>", 0),
                    Toast.LENGTH_SHORT).show()
                //Toast.makeText(this, "USER REGISTERED :D", Toast.LENGTH_LONG).show()
                val intent : Intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, HtmlCompat.fromHtml("<font color= '#FF2400'> <b>" +
                        "ENTER A VALID VALUE!" + "</b></font>", 0),
                    Toast.LENGTH_SHORT).show()
                //Toast.makeText(this, "Enter Value in the fields!", Toast.LENGTH_LONG).show()
            }
        }

        cancel.setOnClickListener() {
            val intent : Intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}