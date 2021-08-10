package com.tech.resumebuilder.ui.skills

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tech.resume_services.ResumeRepository
import com.tech.resume_services.dto.ProfileDTO
import com.tech.resume_services.dto.SkillsDTO
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SkillsViewModel @Inject constructor(resumeRepo: ResumeRepository): ViewModel() {

    val skillList: LiveData<List<SkillsDTO>> = resumeRepo.retrieveSkills()
}