package com.dicoding.mluas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dicoding.mluas.menu.AboutActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvbtn : Button = findViewById(R.id.button)

        tvbtn.setOnClickListener{
            val Home = Intent(this@MainActivity, HomeActivity::class.java)
            startActivity(Home)
        }

    }
}