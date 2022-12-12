package com.esat.apitest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var mMainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.setupViewModel()
    }

    private fun setupViewModel() {
        mMainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        mMainViewModel.getHeroes().observe(this, { heroes ->
            Log.d("HEROES", heroes.toString())

            val heroName: TextView = findViewById(R.id.HeroName)
            heroName.text = heroes.toString()
        })
    }

}