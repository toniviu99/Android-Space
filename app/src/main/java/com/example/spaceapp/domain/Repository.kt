package com.example.spaceapp.domain

import com.example.spaceapp.data.network.response.PredictionResponse
import com.example.spaceapp.domain.model.PredictionModel

interface Repository {
    suspend fun getPrediction(date:String, apiKey:String): PredictionModel?
}