package com.example.spaceapp.data.network

import com.example.spaceapp.data.RepositoryImpl
import com.example.spaceapp.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit():Retrofit{
        return Retrofit
            .Builder()
            .baseUrl("https://api.nasa.gov/planetary/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun providePictureApiService(retrofit: Retrofit):PictureApiService{
        return retrofit.create(PictureApiService::class.java)
    }

    @Provides
    fun provideRepository(apiService: PictureApiService):Repository{
        return RepositoryImpl(apiService)
    }
}