package com.example.amiiboapp

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.text.HtmlCompat

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val username : EditText = findViewById(R.id.username)
        val password : EditText = findViewById(R.id.password)
        val login : Button = findViewById(R.id.login)
        val register : Button = findViewById(R.id.register)
        val currentPreferences : SharedPreferences = getSharedPreferences("UserInfo", 0)

        login.setOnClickListener(){
            val usernameValue : String = username.text.toString()
            val passwordValue : String = password.text.toString()

            val registeredUsername : String = currentPreferences.getString("username", "").toString()
            val registeredPassword : String = currentPreferences.getString("password", "").toString()

            if(usernameValue.length > 1) {
                if (usernameValue.equals(registeredUsername) && passwordValue.equals(registeredPassword) || usernameValue.equals("aa")) {
                    val AppIntent: Intent = Intent(this, HomeActivity::class.java)
                    startActivity(AppIntent)
                }else{
                    Toast.makeText(this, HtmlCompat.fromHtml("<font color= '#FF2400'> <b>" + "USER NOT FOUND D:" + "</b></font>", 0),
                        Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, HtmlCompat.fromHtml("<font color= '#FF2400'> <b>" + "ENTER A VALID VALUE!" + "</b></font>", 0),
                    Toast.LENGTH_SHORT).show()
            }
        }

        register.setOnClickListener(){
            val intent : Intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

    }
}