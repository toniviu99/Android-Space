package com.example.spaceapp.ui.home

import com.example.spaceapp.domain.model.PictureModel

sealed class MainState {
    data object Loading : MainState()
    data class Error(val error: String):MainState()
    data class Success(val predictionModel: PictureModel):MainState()
}