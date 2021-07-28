package com.tech.resumebuilder.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(): ViewModel() {

    private val _name = MutableLiveData<String>().apply {
        value = "Mahavir Anil Dere"
    }
    val name: LiveData<String> = _name

    private val _address = MutableLiveData<String>().apply {
        value = "Aashirwad Heritage, B-808, Near Sane Chowk Chikhali Pune 412114."
    }
    val address: LiveData<String> = _address

    private val _dob = MutableLiveData<String>().apply {
        value = "29/07/2021"
    }
    val dob: LiveData<String> = _dob

    private val _nationality = MutableLiveData<String>().apply {
        value = "Indian"
    }
    val nationality: LiveData<String> = _nationality

    private val _hobbies = MutableLiveData<String>().apply {
        value = "Listen to Music"
    }
    val hobbies: LiveData<String> = _hobbies

    private val _maritalStatus = MutableLiveData<String>().apply {
        value = "Married"
    }
    val maritalStatus: LiveData<String> = _maritalStatus

    private val _mobNo = MutableLiveData<String>().apply {
        value = "+91-9860242163"
    }
    val mobNo: LiveData<String> = _mobNo
}