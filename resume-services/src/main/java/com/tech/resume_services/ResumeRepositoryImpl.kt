package com.tech.resume_services

import com.tech.resume_services.dto.ExperienceDTO
import com.tech.resume_services.dto.MoreDetailsDTO
import com.tech.resume_services.dto.ProfileDTO
import com.tech.resume_services.dto.SkillsDTO
import javax.inject.Inject

class ResumeRepositoryImpl @Inject constructor() :ResumeRepository {

    override fun retrieveProfile(): ProfileDTO {
        val pDto = ProfileDTO("Mahavir Anil Dere")
        return pDto
    }

    override fun retrieveSkills(): SkillsDTO {
        return SkillsDTO()
    }

    override fun retrieveExperience(): ExperienceDTO {
        return ExperienceDTO()
    }

    override fun retrieveMoreDetails(): MoreDetailsDTO {
        return MoreDetailsDTO()
    }
}