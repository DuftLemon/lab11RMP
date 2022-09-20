package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickConclusion(view: View) {
        val intent = Intent(this, MainActivity3::class.java)
        startActivity(intent)
    }
    fun onClickInput(view: View) {
        val intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)
    }
}