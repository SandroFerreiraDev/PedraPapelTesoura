package com.ferreirasandro.pedrapapeltesoura

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btn1x1 = findViewById<Button>(R.id.btn1x1)
        btn1x1.setOnClickListener {
            val intent = Intent(this, Game1x1Activity::class.java)
            startActivity(intent)
        }
        val btn1x1x1 = findViewById<Button>(R.id.btn1x1x1)
        btn1x1x1.setOnClickListener {
            val intent = Intent(this, Game1x1x1Activity::class.java)
            startActivity(intent)
        }
    }
}