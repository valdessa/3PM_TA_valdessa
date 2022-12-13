package com.example.amiiboapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.amiiboapp.databinding.ActivityAmiiboInfoActiviyBinding
import com.squareup.picasso.Picasso

class AmiiboInfoActiviy : AppCompatActivity() {

    private lateinit var binding : ActivityAmiiboInfoActiviyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAmiiboInfoActiviyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val img = intent.getStringExtra("img")
        Picasso.with(this).load(img.toString()).into( binding.imageView);

        val series = intent.getStringExtra("series")
        val release = intent.getStringExtra("release")

        binding.dataName.text = intent.getStringExtra("name")
        binding.dataSaga.text = series.toString()
        binding.dataRelease.text = release.toString()



    }
}