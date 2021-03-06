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
abstract class ResumeModule {

    private val baseUrl = "https://resumeapi.s3.ap-south-1.amazonaws.com"

    @Binds
    abstract fun provideResumeRepository(resumeRepoImpl: ResumeRepositoryImpl): ResumeRepository
}