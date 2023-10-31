package com.example.spaceapp.data.network.response

import com.example.spaceapp.domain.model.PredictionModel

class PredictionResponse : ArrayList<PredictionResponseItem>(){
    fun toDomain():PredictionModel{
        return PredictionModel(
             info = map { it.toDomain() }
        )
    }
}