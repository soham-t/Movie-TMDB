package com.example.pgp36085

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AuxActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        var i:Intent = intent
        var name: TextView = findViewById(R.id.name)
        name.text = i.extras?.getString("name")
        var description: TextView = findViewById(R.id.description)
        description.text = i.extras?.getString("description")
        var ratings: TextView = findViewById(R.id.ratings)
        ratings.text = i.extras?.getString("rating")
        var release: TextView = findViewById(R.id.release)
        release.text = i.extras?.getString("release")
    }
}