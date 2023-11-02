package com.example.spaceapp.domain

import com.example.spaceapp.domain.model.PictureModel

interface Repository {
    suspend fun getPrediction(date:String, apiKey:String): PictureModel?
}