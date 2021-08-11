package com.tech.resumebuilder.ui.experience

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tech.resume_services.ResumeRepository
import com.tech.resume_services.dto.ProjectDTO
import com.tech.resume_services.dto.SkillsDTO
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ExperienceViewModel @Inject constructor(resumeRepo: ResumeRepository) : ViewModel() {

    val projectList: LiveData<List<ProjectDTO>> = resumeRepo.retrieveProjects()
}