package com.example.spaceapp.domain.model

import com.google.gson.annotations.SerializedName

data class PredictionModelItem(
    val copyright: String,
    val date: String,
    val explanation: String,
    val title: String,
    val imageUrl: String
)
