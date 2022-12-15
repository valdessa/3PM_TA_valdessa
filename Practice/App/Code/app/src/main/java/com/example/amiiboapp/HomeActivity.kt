package com.example.amiiboapp

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.squareup.picasso.Picasso

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()

        setContentView(R.layout.activity_home)

        val currentListView : ListView = findViewById(R.id.charactersList)

        this.getSmashCharacter{ list->
            currentListView.isClickable = true;
            currentListView.adapter = CustomAdapter(this, list);

            currentListView.setOnItemClickListener(AdapterView.OnItemClickListener { parent, view, position, id ->

                val i = Intent(this, AmiiboInfoActiviy::class.java)
                i.putExtra("name", list[position].Name)
                i.putExtra("series", list[position].Series)
                i.putExtra("img", list[position].Image)
                i.putExtra("release", list[position].Release)

                startActivity(i)
            })
        }
    }

    fun getSmashCharacter(callback: (MutableList<SmashBrosEntity>) -> Unit){
        val url = "https:///smashbrosprueba.free.beeceptor.com/characters"

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null, {
                    response ->
                Log.ERROR

                //Parsing JSON:
                val jsonList = response.getJSONArray("amiibo").toString()
                val mutablelistType = object : TypeToken<MutableList<SmashBrosEntity>>(){}.type
                val CharactersList = Gson().fromJson<MutableList<SmashBrosEntity>>(jsonList, mutablelistType)

                callback(CharactersList)
            },
            { error ->
                // TODO: Handle error
                Log.ERROR
            }
        )

        val requestQueue = Volley.newRequestQueue(this)
        requestQueue.add(jsonObjectRequest)
    }

    class CustomAdapter(private val context : Activity, private val arrayList : MutableList<SmashBrosEntity>)
        : ArrayAdapter<SmashBrosEntity>(context, R.layout.row_data, arrayList){

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

            val inflater : LayoutInflater = LayoutInflater.from(context)
            val newView : View = inflater.inflate(R.layout.row_data, null)

            val myNameView : TextView = newView.findViewById(R.id.smashNames);
            val myImageView: ImageView = newView.findViewById(R.id.images);

            myNameView.text = arrayList[position].Name
            Picasso.with(context).load(arrayList[position].Image.toString()).into(myImageView);

            return newView
        }
    }
}