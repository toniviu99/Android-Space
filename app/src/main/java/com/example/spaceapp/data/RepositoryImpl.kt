package com.example.spaceapp.data

import android.util.Log
import com.example.spaceapp.data.network.PictureApiService
import com.example.spaceapp.data.network.response.PredictionResponse
import com.example.spaceapp.domain.Repository
import com.example.spaceapp.domain.model.PredictionModel
import retrofit2.Retrofit
import javax.inject.Inject
import kotlin.math.sign

class RepositoryImpl @Inject constructor(private val apiService: PictureApiService): Repository {
    override suspend fun getPrediction(date: String, apiKey: String):PredictionModel? {
        runCatching { apiService.getPicture(date,apiKey) }
            .onSuccess {
                return it.toDomain()
            }
            .onFailure {
                Log.i("toni","Ha ocurrido un error ${it.message}")
            }
        return null
    }
}