package com.rootcode.storisapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rootcode.storisapp.databinding.ActivityMainBinding
import com.rootcode.storisapp.databinding.ActivityStoryBinding

class storyActivity : AppCompatActivity() {
    private lateinit var binding :ActivityStoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityStoryBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.titleSecond.text = intent.getStringExtra("title")
        binding.details.text = intent.getStringExtra("details")
        binding.img.setImageResource(intent.getIntExtra("Image",0))
    }
}