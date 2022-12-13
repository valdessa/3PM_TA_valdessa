package com.example.amiiboapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        this.getSmashCharacter{ smash->
            val myTextView: TextView = findViewById(R.id.characters);
            myTextView.text = smash.toString()//"Pokemon ID: %s".format(smash)
        }
    }

    fun getSmashCharacter(callback: (MutableList<SmashBrosEntity>) -> Unit){
        val url = "https://smashbroscharacters.free.beeceptor.com/characters"

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null, Response.Listener {
                    response ->
                Log.ERROR

                //Parsear JSON:
                val jsonList = response.getJSONArray("amiibo").toString()
                val mutablelistType = object : TypeToken<MutableList<SmashBrosEntity>>(){}.type
                val pokemonList = Gson().fromJson<MutableList<SmashBrosEntity>>(jsonList, mutablelistType)

                callback(pokemonList)
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