package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class reisgter : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reisgter)
        val button = findViewById<View>(R.id.btn_regis)
        button.setOnClickListener {
            val intent = Intent(this@reisgter, MainActivity::class.java)
            startActivity(intent)
        }
    }
}