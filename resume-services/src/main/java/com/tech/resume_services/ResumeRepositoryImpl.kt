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

class ResumeRepositoryImpl @Inject constructor() :ResumeRepository {

    @Inject lateinit var resumeApi: ResumeApi

    override fun retrieveProfile(): LiveData<ProfileDTO> {
        val profileDto:MutableLiveData<ProfileDTO> = MutableLiveData()
        val profileApi = resumeApi.retrieveProfile()
        Log.i("@ResumeBuilder", "Calling Profile API")
        profileApi.enqueue(object : Callback<ProfileDTO> {
            override fun onResponse(call: Call<ProfileDTO>?, response: Response<ProfileDTO>?) {
                Log.i("@ResumeBuilder", "Response Received for Profile API $response")
                if(response?.body() != null)
                    profileDto.value = response.body()!!
                else
                    Log.i("@ResumeBuilder", "Response Body not found for Profile API")
            }

            override fun onFailure(call: Call<ProfileDTO>?, t: Throwable?) {
                Log.i("@ResumeBuilder", "Error while connecting to Profile API (JSON)")
            }
        })
//        val pDto = ProfileDTO("Mahavir Anil Dere")
        return profileDto
    }

    override fun retrieveSkills(): LiveData<List<SkillsDTO>> {
        val skillsList:MutableLiveData<List<SkillsDTO>> = MutableLiveData<List<SkillsDTO>>()
        val skillsApi = resumeApi.retrieveSkills()
        Log.i("@ResumeBuilder", "Calling Skills API")
        skillsApi.enqueue(object : Callback<List<SkillsDTO>> {
            override fun onResponse(call: Call<List<SkillsDTO>>?, response: Response<List<SkillsDTO>>?) {
                Log.i("@ResumeBuilder", "Response Received for Skills API $response")
                if(response?.body() != null)
                    skillsList.value = response.body()!!
                else
                    Log.i("@ResumeBuilder", "Response Body not found for Skills API")
            }

            override fun onFailure(call: Call<List<SkillsDTO>>?, t: Throwable?) {
                Log.i("@ResumeBuilder", "Error while connecting to Skills API (JSON)")
            }
        })
        return skillsList
    }

    override fun retrieveProjects(): LiveData<List<ProjectDTO>> {
        val projectList:MutableLiveData<List<ProjectDTO>> = MutableLiveData<List<ProjectDTO>>()
        val projectsApi = resumeApi.retrieveProjects()
        Log.i("@ResumeBuilder", "Calling Project API")
        projectsApi.enqueue(object : Callback<List<ProjectDTO>> {
            override fun onResponse(call: Call<List<ProjectDTO>>?, response: Response<List<ProjectDTO>>?) {
                Log.i("@ResumeBuilder", "Response Received for Project API $response")
                if(response?.body() != null)
                    projectList.value = response.body()!!
                else
                    Log.i("@ResumeBuilder", "Response Body not found for Project API")
            }

            override fun onFailure(call: Call<List<ProjectDTO>>?, t: Throwable?) {
                Log.i("@ResumeBuilder", "Error while connecting to Project API (JSON)")
            }
        })
        return projectList
    }

    override fun retrieveMoreDetails(): LiveData<MoreDetailsDTO> {
        val moreDetDto:MutableLiveData<MoreDetailsDTO> = MutableLiveData()
        val moreDetApi = resumeApi.retrieveMoreDetails()
        Log.i("@ResumeBuilder", "Calling More Details API")
        moreDetApi.enqueue(object : Callback<MoreDetailsDTO> {
            override fun onResponse(call: Call<MoreDetailsDTO>?, response: Response<MoreDetailsDTO>?) {
                Log.i("@ResumeBuilder", "Response Received for More Details API $response")
                if(response?.body() != null)
                    moreDetDto.value = response.body()!!
                else
                    Log.i("@ResumeBuilder", "Response Body not found for More Details API")
            }

            override fun onFailure(call: Call<MoreDetailsDTO>?, t: Throwable?) {
                Log.i("@ResumeBuilder", "Error while connecting to More Details API (JSON) ${t?.message}")
            }
        })
        return moreDetDto
    }
}