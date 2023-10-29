package com.example.spaceapp.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.spaceapp.R
import com.example.spaceapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}