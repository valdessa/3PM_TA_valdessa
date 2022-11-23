package com.example.testdependencies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val myTextView: TextView = findViewById(R.id.Sebitas);

        val url = "https://testpokemonapi.free.beeceptor.com/pokemon"

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null, Response.Listener {
                    response ->
                    Log.ERROR
                    myTextView.text = "Response: %s".format(response.toString())
            },
            Response.ErrorListener { error ->
                // TODO: Handle error
                Log.ERROR
            }
            // Access the RequestQueue through your singleton class.
            //MySingleton.getInstance(this).addToRequestQueue.add(jsonObjectRequest)

        )
        val requestQueue = Volley.newRequestQueue(this)
        requestQueue.add(jsonObjectRequest)
    }
}


