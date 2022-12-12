package com.esat.apitest

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

class HeroApi constructor(context: Context) {

    companion object{
        @Volatile
        private var INSTANCE: HeroApi? = null

        fun getInstance(context: Context) = INSTANCE?: synchronized(this){
            INSTANCE ?: HeroApi(context).also { INSTANCE = it }
        }

    }

    val requestQueue: RequestQueue by lazy {
        Volley.newRequestQueue(context.applicationContext)
    }

    fun <T> addToRequestQueue(req: Request<T>) {
        requestQueue.add(req)
    }

}