package com.mattboone.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent

import com.mattboone.recycleview.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val titles = MainViewModel.getTitles()
        val details = MainViewModel.getDetails()
        val images = MainViewModel.getImages()
        val extras = intent.extras ?: return
        val titleNum = extras.getInt("num1")
        val detailNum = extras.getInt("num2")
        val imageNum = extras.getInt("num3")
        binding.chapterText.text = titles[titleNum]
        binding.detailText.text = details[detailNum]
        binding.imageView.setImageResource(images[imageNum])
    }
}