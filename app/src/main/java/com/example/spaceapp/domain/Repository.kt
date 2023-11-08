package com.example.spaceapp.domain

import com.example.spaceapp.domain.model.PictureModel

interface Repository {
    suspend fun getPicture(date:String, apiKey:String): PictureModel?
}