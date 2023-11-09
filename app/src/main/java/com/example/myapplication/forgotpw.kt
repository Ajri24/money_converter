package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class forgotpw : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgotpw)
        val button = findViewById<View>(R.id.btn_regis)
        button.setOnClickListener {
            val intent = Intent(this@forgotpw, login::class.java)
            startActivity(intent)
        }
    }
}