package com.rootcode.storisapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.rootcode.storisapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(binding.root)

        binding.storyRecycle.layoutManager = LinearLayoutManager(this)
        val storyList = listOf<storyModel>(
            storyModel("The Forgotten Journal",resources.getString(R.string.story1),R.drawable.story1),
            storyModel("The Forgotten Journal",resources.getString(R.string.story1),R.drawable.story1),
            storyModel("The Forgotten Journal",resources.getString(R.string.story1),R.drawable.story1)
        )
        binding.storyRecycle.adapter = storyAdapter(storyList){
            selectedItem:storyModel -> listItemClicked(selectedItem)
        }

    }
    private fun listItemClicked(story:storyModel){
        var intent = Intent(this@MainActivity,storyActivity::class.java)
        intent.putExtra("title",story.title)
        intent.putExtra("details",story.details)
        intent.putExtra("Image",story.Image)
        startActivity(intent)
    }
}