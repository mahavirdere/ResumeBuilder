package com.tech.resume_services

import com.tech.resume_services.dto.ProfileDTO
import com.tech.resume_services.dto.SkillsDTO
import retrofit2.Call
import retrofit2.http.GET

interface ResumeApi {

    @GET("/profile.json")
    fun retrieveProfile(): Call<ProfileDTO>

    @GET("/skills.json")
    fun retrieveSkills(): Call<List<SkillsDTO>>
}