package com.example.amiiboapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import com.example.amiiboapp.databinding.ActivityAmiiboInfoActivityBinding
import com.squareup.picasso.Picasso

class AmiiboInfoActiviy : AppCompatActivity() {

    private lateinit var binding : ActivityAmiiboInfoActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()

        binding = ActivityAmiiboInfoActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val img = intent.getStringExtra("img")
        Picasso.with(this).load(img.toString()).into( binding.imageView);

        binding.dataName.text = intent.getStringExtra("name")
        binding.dataSaga.text = intent.getStringExtra("series")
        binding.dataRelease.text = intent.getStringExtra("release")



    }
}