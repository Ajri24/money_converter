package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadActivity(profile::class.java)
        loadFragment(calc())



        var bottomnvamenu = findViewById<BottomNavigationView>(R.id.bot_menu)
        bottomnvamenu.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    loadFragment(home())
                    true
                }
                R.id.calc -> {
                    loadFragment(calc())
                    true
                }
                R.id.scale -> {
                    loadFragment(bmi())
                    true
                }
                R.id.convert -> {
                    loadFragment(converter())
                    true
                }


                else -> {
                    false
                }



            }
    }
}
    private fun loadActivity(profile: Class<profile>) {
        val intent = Intent(this, profile)
        startActivity(intent)
    }
    private  fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
        }
}