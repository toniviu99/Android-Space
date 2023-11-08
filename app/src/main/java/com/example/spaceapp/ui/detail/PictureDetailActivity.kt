package com.example.spaceapp.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.spaceapp.R
import com.example.spaceapp.databinding.ActivityPictureDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PictureDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPictureDetailBinding
    private val pictureDetailViewModel:PictureDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPictureDetailBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_picture_detail)
    }
}