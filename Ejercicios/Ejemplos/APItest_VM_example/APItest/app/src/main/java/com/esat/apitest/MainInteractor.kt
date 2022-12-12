package com.esat.apitest

import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import android.util.Log
import com.esat.apitest.Constants
import com.esat.apitest.HeroApplication
import com.esat.apitest.HeroEntity

class MainInteractor {

    fun getHeroes(callback: (MutableList<HeroEntity>) -> Unit ){
        // API REQUEST
        val url = Constants.API_URL + Constants.HEROES_PATH

        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null, { response ->

            val status = response.optInt(Constants.STATUS, Constants.ERROR)
            Log.i("status", status.toString())

            if (status == Constants.SUCCESS){
                val jsonList = response.getJSONArray(Constants.HEROES_PROPERTY).toString()
                val mutableListType = object : TypeToken<MutableList<HeroEntity>>(){}.type
                val heroesList = Gson().fromJson<MutableList<HeroEntity>>(jsonList, mutableListType)

                callback(heroesList)
            }
        },{ error ->
            error.printStackTrace()
        })

        // REQUEST

//        var requestQueue = Volley.newRequestQueue(this)
//        requestQueue.add(jsonObjectRequest)

        HeroApplication.heroAPI.addToRequestQueue(jsonObjectRequest)
    }

}