package com.tech.resume_services

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tech.resume_services.dto.ProjectDTO
import com.tech.resume_services.dto.MoreDetailsDTO
import com.tech.resume_services.dto.ProfileDTO
import com.tech.resume_services.dto.SkillsDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ResumeRepositoryTestImpl :ResumeRepository {

    override fun retrieveProfile(): LiveData<ProfileDTO> {
        val profileDto:MutableLiveData<ProfileDTO> = MutableLiveData<ProfileDTO>().apply {
            value = ProfileDTO("Mahavir Dere","Address1","25/11/1987","Indian","Swimming", "Married", "9860242163")
        }
        return profileDto
    }

    override fun retrieveSkills(): LiveData<List<SkillsDTO>> {
        val skillsList:MutableLiveData<List<SkillsDTO>> = MutableLiveData<List<SkillsDTO>>().apply {
            value = arrayListOf(SkillsDTO("Java", 3.2F),SkillsDTO("Android", 4.5F))
        }
        return skillsList
    }

    override fun retrieveProjects(): LiveData<List<ProjectDTO>> {
        val projectList:MutableLiveData<List<ProjectDTO>> = MutableLiveData<List<ProjectDTO>>().apply {
            value = arrayListOf(ProjectDTO(0,"Resume Builder", "Resume Builder App", "12-10-2020 To 31-12-2021", "Developer", "Java, Spring"), ProjectDTO(0,"CAB Management", "CAB Management Web Portal", "26-05-2018 To 30-09-2019", "Tester", "Android, Kotlin"))
        }
        return projectList
    }

    override fun retrieveMoreDetails(): LiveData<MoreDetailsDTO> {
        val moreDetDto:MutableLiveData<MoreDetailsDTO> = MutableLiveData<MoreDetailsDTO>().apply {
            value = MoreDetailsDTO(arrayOf("SCJP","AWS Solution Architect", "GCD"), "www.github.com/mahavirdere/",  "www.linkedin.com/mahavirdere/", "www.blogspot.com/mahavirdere/", "www.drive.com/mahavirdere.pdf")
        }
        return moreDetDto
    }
}