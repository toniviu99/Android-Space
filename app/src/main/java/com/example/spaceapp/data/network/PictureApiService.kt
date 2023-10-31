package com.example.spaceapp.data.network

import com.example.spaceapp.data.network.response.PredictionResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PictureApiService {

//    @GET("apod?start_date={date}&api_key={apiKey}")
//    suspend fun getPicture(@Path("date") date:String, @Path("apiKey") apiKey: String):PredictionResponse
    @GET("apod")
    suspend fun getPicture(@Query("start_date") date:String, @Query("api_key") apiKey: String):PredictionResponse

}