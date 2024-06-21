package com.dicoding.mluas.menu

import android.graphics.Color
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dicoding.mluas.R

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        val linkTextView = findViewById<TextView>(R.id.textView10)
        linkTextView.movementMethod = LinkMovementMethod.getInstance()
        linkTextView.setLinkTextColor(Color.BLUE)
    }
}