package com.tech.resume_services

import com.tech.resume_services.dto.ProfileDTO
import retrofit2.Call
import retrofit2.http.GET

interface ResumeApi {

    @GET("/profile.json")
    fun retrieveProfile(): Call<ProfileDTO>
}