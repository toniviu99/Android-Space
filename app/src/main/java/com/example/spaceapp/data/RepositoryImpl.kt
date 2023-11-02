package com.example.spaceapp.data

import android.util.Log
import com.example.spaceapp.data.network.PictureApiService
import com.example.spaceapp.domain.Repository
import com.example.spaceapp.domain.model.PictureModel
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: PictureApiService): Repository {
    override suspend fun getPrediction(date: String, apiKey: String):PictureModel? {
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