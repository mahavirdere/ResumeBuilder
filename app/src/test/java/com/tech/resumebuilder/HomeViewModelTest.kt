package com.tech.resumebuilder

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.tech.resume_services.ResumeRepository
import com.tech.resume_services.ResumeRepositoryTestImpl
import com.tech.resume_services.dto.ProfileDTO
import com.tech.resumebuilder.ui.home.HomeViewModel
import junit.framework.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class HomeViewModelTest {

    private lateinit var homeViewModel: HomeViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()


    @Before
    fun initViewModel() {
        val resumeRepo:ResumeRepository = ResumeRepositoryTestImpl()
        homeViewModel = HomeViewModel(resumeRepo)
    }

    @Test
    fun `Profile Data Success Test`(){
        val homeDto: ProfileDTO = homeViewModel.profileDto.getOrAwaitValue()
        assertNotNull(homeDto)
        assertEquals("Mahavir Dere", homeDto.name)
        assertEquals("Address1", homeDto.address)
        assertEquals("9860242163", homeDto.mobNo)
    }
}