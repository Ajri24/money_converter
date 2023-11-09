package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class login : AppCompatActivity() {
    private var login: Button? = null
    private var username: EditText? = null
    private var password: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        username = findViewById<View>(R.id.user) as EditText
        password = findViewById<View>(R.id.pwd) as EditText
        login = findViewById<View>(R.id.btn_login) as Button
        login!!.setOnClickListener { openhome() }

        val button = findViewById<View>(R.id.btn_regis)
        button.setOnClickListener {
            val intent = Intent(this@login, reisgter::class.java)
            startActivity(intent)
        }

        val button2 = findViewById<View>(R.id.btn_forget)
        button.setOnClickListener {
            val intent = Intent(this@login, forgot::class.java)
            startActivity(intent)
        }

    }

    fun openhome() {
        if (username!!.text.toString() == "user" && password!!.text.toString() == "1234") {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(this@login, "Login Failed", Toast.LENGTH_SHORT).show()
        }
    }

}