package com.tech.resume_services

import androidx.lifecycle.LiveData
import com.tech.resume_services.dto.ProjectDTO
import com.tech.resume_services.dto.MoreDetailsDTO
import com.tech.resume_services.dto.ProfileDTO
import com.tech.resume_services.dto.SkillsDTO

interface ResumeRepository {

    fun retrieveProfile(): LiveData<ProfileDTO>

    fun retrieveSkills(): LiveData<List<SkillsDTO>>

    fun retrieveProjects(): LiveData<List<ProjectDTO>>

    fun retrieveMoreDetails(): LiveData<MoreDetailsDTO>
}