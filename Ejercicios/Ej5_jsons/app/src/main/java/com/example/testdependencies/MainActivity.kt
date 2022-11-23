package com.example.testdependencies

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.ProxyFileDescriptorCallback
import android.util.Log
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Esto es para guardar settings:
        val sharedPreference = getSharedPreferences("settings", Context.MODE_PRIVATE)
        val edit = sharedPreference.edit()
        edit.putString("heroe", "Goku")
        edit.commit()

        //es lo mismo quelo e abajo, solo que en una linea:
        // val sharedPreference = getSharedPreferences("settings", Context.MODE_PRIVATE).edit.putString("heroe", "Goku").commit()

        var heroName = sharedPreference.getString("heroe", "")


        this.getPokemon{ pokemon->
            val myTextView: TextView = findViewById(R.id.Sebitas);
            myTextView.text = "Pokemon ID: %s".format(pokemon)
        }
    }

    fun getPokemon(callback: (MutableList<PokemonEntity>) -> Unit){
        val url = "https://testpokemonapi.free.beeceptor.com/pokemon"

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null, Response.Listener {
                    response ->
                Log.ERROR

                //myTextView.text = "Response: %s".format(response.toString())
                //Parsear JSON:
                val jsonList = response.getJSONArray("Pokemon").toString()
                val mutablelistType = object : TypeToken<MutableList<PokemonEntity>>(){}.type
                val pokemonList = Gson().fromJson<MutableList<PokemonEntity>>(jsonList, mutablelistType)

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


