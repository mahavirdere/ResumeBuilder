package com.tech.resume_services

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
 object RetrofitModule {

    private val baseUrl = "https://resumeapi.s3.ap-south-1.amazonaws.com"

    @Provides
    fun provideResumeApi():ResumeApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
            .create(ResumeApi::class.java)
    }
}