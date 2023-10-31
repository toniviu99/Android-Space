package com.example.spaceapp.domain.usecase

import com.example.spaceapp.domain.Repository
import javax.inject.Inject

class GetPredictionUseCase @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(date:String, apiKey:String) = repository.getPrediction(date, apiKey)
}