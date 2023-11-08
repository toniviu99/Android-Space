package com.example.spaceapp.data.network.response

import com.example.spaceapp.domain.model.PictureModel

class PictureResponse : ArrayList<PictureResponseItem>(){
    fun toDomain():PictureModel{
        return PictureModel(
            info = map { it.toDomain() }
        )
    }
}