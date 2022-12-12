package com.esat.apkcreatetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.getHeroes { heroesList ->
            val heroesTextView: TextView = findViewById(R.id.heroesTextView)
            heroesTextView.text = heroesList.toString()
        }
    }

    fun getHeroes(callback: (MutableList<HeroeEntity>) -> Unit ){
        val url = Constants.API_URL + Constants.HEROES_PATH
        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null, { response ->
            val status = response.optInt(Constants.STATUS, Constants.ERROR)
            if (status == Constants.SUCCESS) {
                val jsonList = response.getJSONArray(Constants.HEROES_PROPERTY).toString()
                val mutableListType = object : TypeToken<MutableList<HeroeEntity>>(){}.type
                val heroesList = Gson().fromJson<MutableList<HeroeEntity>>(jsonList, mutableListType)

                callback(heroesList)
            }
        },{ error ->
            error.printStackTrace()
        })

        var requestQueue = Volley.newRequestQueue(this)
        requestQueue.add(jsonObjectRequest)
    }

}