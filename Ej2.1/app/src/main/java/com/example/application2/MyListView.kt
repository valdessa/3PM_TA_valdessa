package com.example.application2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView

class MyListView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_list_view)

        val listTestView: ListView = this.findViewById(R.id.listTestView)
        val pkmn = arrayOf(
            "Pikachu",
            "Piplup",
            "Chimchar",
            "Turtwig",
            "Giratina",
            "Dialga",
            "Palkia",
            "Arceus",
            "Darkrai"
        )
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, pkmn)

        listTestView.adapter = adapter
        listTestView.setOnItemClickListener { adapterView, view, i, l ->
            Log.d("LIST", "Item tap")
        }
    }
}