package com.tech.resumebuilder.ui.moreDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.tech.resume_services.ResumeRepository
import com.tech.resume_services.dto.MoreDetailsDTO
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MoreDetailsViewModel @Inject constructor(resumeRepo: ResumeRepository) : ViewModel() {

    val moreDetDto: LiveData<MoreDetailsDTO> = resumeRepo.retrieveMoreDetails()
}