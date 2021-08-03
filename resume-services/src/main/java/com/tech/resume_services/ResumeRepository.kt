package com.tech.resume_services

import com.tech.resume_services.dto.ExperienceDTO
import com.tech.resume_services.dto.MoreDetailsDTO
import com.tech.resume_services.dto.ProfileDTO
import com.tech.resume_services.dto.SkillsDTO

interface ResumeRepository {

    fun retrieveProfile(): ProfileDTO

    fun retrieveSkills(): SkillsDTO

    fun retrieveExperience(): ExperienceDTO

    fun retrieveMoreDetails(): MoreDetailsDTO
}