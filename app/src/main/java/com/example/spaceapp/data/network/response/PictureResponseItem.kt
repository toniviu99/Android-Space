package com.example.spaceapp.data.network.response

import com.example.spaceapp.domain.model.PictureModelItem
import com.google.gson.annotations.SerializedName

data class PictureResponseItem(
    @SerializedName("copyright") val copyright: String,
    @SerializedName("date") val date: String,
    @SerializedName("explanation") val explanation: String,
    @SerializedName("title") val title: String,
    @SerializedName("url") val imageUrl: String
){
    fun toDomain():PictureModelItem{
        return PictureModelItem(
            copyright = copyright,
            date = date,
            explanation = explanation,
            title = title,
            imageUrl = imageUrl
        )
    }
}