package com.tech.resume_services

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tech.resume_services.dto.ExperienceDTO
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

    override fun retrieveExperience(): ExperienceDTO {
        return ExperienceDTO()
    }

    override fun retrieveMoreDetails(): MoreDetailsDTO {
        return MoreDetailsDTO()
    }
}