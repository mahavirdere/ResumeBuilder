package com.tech.resume_services

import com.tech.resume_services.dto.MoreDetailsDTO
import com.tech.resume_services.dto.ProfileDTO
import com.tech.resume_services.dto.ProjectDTO
import com.tech.resume_services.dto.SkillsDTO
import retrofit2.Call
import retrofit2.http.GET

interface ResumeApi {

    @GET("/profile.json")
    fun retrieveProfile(): Call<ProfileDTO>

    @GET("/skills.json")
    fun retrieveSkills(): Call<List<SkillsDTO>>

    @GET("/projects.json")
    fun retrieveProjects(): Call<List<ProjectDTO>>

    @GET("/more-details.json")
    fun retrieveMoreDetails(): Call<MoreDetailsDTO>
}