package com.example.spaceapp.domain.usecase

import com.example.spaceapp.domain.Repository
import javax.inject.Inject

class GetPictureUseCase @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(date:String, apiKey:String) = repository.getPicture(date, apiKey)
}