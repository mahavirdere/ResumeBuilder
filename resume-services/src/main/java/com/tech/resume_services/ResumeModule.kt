package com.tech.resume_services

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ResumeModule {

    @Binds
    abstract fun provideResumeRepository(resumeRepoImpl: ResumeRepositoryImpl): ResumeRepository
}