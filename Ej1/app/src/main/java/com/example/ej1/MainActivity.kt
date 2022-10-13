package com.example.ej1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.example.ej1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_esatlinear)

        val intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)

        Log.e("MachineState", "onCreate executed")
    }

    override fun onStart() {
        super.onStart()

        Log.e("MachineState", "onStart executed")
    }

    override fun onResume() {
        super.onResume()

        Log.e("MachineState", "onResume executed")
    }

    override fun onPause() {
        super.onPause()

        Log.e("MachineState", "onPause executed")
    }

    override fun onStop() {
        super.onStop()

        Log.e("MachineState", "onStop executed")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.e("MachineState", "onDestroy executed")
    }



};