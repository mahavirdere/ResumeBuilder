package com.tech.resumebuilder.ui.home

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tech.resume_services.ResumeRepository
import com.tech.resume_services.dto.ProfileDTO
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(resumeRepo: ResumeRepository): ViewModel() {

    val profileDto: LiveData<ProfileDTO> = resumeRepo.retrieveProfile()

    fun updateProfileData(pDto:ProfileDTO) {
        _name.value = pDto.name
        _address.value = pDto.address
        _dob.value = pDto.dob
        _nationality.value = pDto.nationality
        _hobbies.value = pDto.hobbies
        _maritalStatus.value = pDto.maritalStatus
        _mobNo.value = pDto.mobNo
    }
    private var _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    private val _address = MutableLiveData<String>()
    val address: LiveData<String> = _address

    private val _dob = MutableLiveData<String>()
    val dob: LiveData<String> = _dob

    private val _nationality = MutableLiveData<String>()
    val nationality: LiveData<String> = _nationality

    private val _hobbies = MutableLiveData<String>()
    val hobbies: LiveData<String> = _hobbies

    private val _maritalStatus = MutableLiveData<String>()
    val maritalStatus: LiveData<String> = _maritalStatus

    private val _mobNo = MutableLiveData<String>()
    val mobNo: LiveData<String> = _mobNo
}