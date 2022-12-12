package com.esat.apitest

import android.app.Application

class HeroApplication : Application() {

    companion object {
        lateinit var heroAPI: HeroApi
    }

    override fun onCreate() {
        super.onCreate()

        heroAPI = HeroApi.getInstance(this)
    }

}