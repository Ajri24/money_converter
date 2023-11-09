package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class forgot : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot)
        val button = findViewById<View>(R.id.btn_reset)
        button.setOnClickListener {
            val intent = Intent(this@forgot, login::class.java)
            startActivity(intent)
        }
    }
}