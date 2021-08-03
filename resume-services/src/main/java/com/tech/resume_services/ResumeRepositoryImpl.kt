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
import retrofit2.Retrofit
import javax.inject.Inject

class ResumeRepositoryImpl @Inject constructor() :ResumeRepository {

    @Inject lateinit var resumeApi: ResumeApi

    override fun retrieveProfile(): LiveData<ProfileDTO> {
        val profileDto:MutableLiveData<ProfileDTO> = MutableLiveData()
        val profileApi = resumeApi.retrieveProfile()
        Log.i("@ResumeBuilder", "Calling API")
        profileApi.enqueue(object : Callback<ProfileDTO> {
            override fun onResponse(call: Call<ProfileDTO>?, response: Response<ProfileDTO>?) {
                Log.i("@ResumeBuilder", "Response Received for API $response")
                if(response?.body() != null)
                    profileDto.value = response.body()!!
                else
                    Log.i("@ResumeBuilder", "Response Body not found for API")
            }

            override fun onFailure(call: Call<ProfileDTO>?, t: Throwable?) {
                Log.i("@ResumeBuilder", "Error while connecting to Profile API (JSON)")
            }
        })
//        val pDto = ProfileDTO("Mahavir Anil Dere")
        return profileDto
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