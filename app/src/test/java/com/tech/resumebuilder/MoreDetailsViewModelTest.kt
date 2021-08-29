package com.tech.resumebuilder

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.tech.resume_services.ResumeRepository
import com.tech.resume_services.ResumeRepositoryTestImpl
import com.tech.resume_services.dto.MoreDetailsDTO
import com.tech.resume_services.dto.ProfileDTO
import com.tech.resumebuilder.ui.home.HomeViewModel
import com.tech.resumebuilder.ui.moreDetails.MoreDetailsViewModel
import junit.framework.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class MoreDetailsViewModelTest {

    private lateinit var moreDetViewModel: MoreDetailsViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()


    @Before
    fun initViewModel() {
        val resumeRepo:ResumeRepository = ResumeRepositoryTestImpl()
        moreDetViewModel = MoreDetailsViewModel(resumeRepo)
    }

    @Test
    fun `Check More Details Exists`(){
        val moreDetDTO: MoreDetailsDTO = moreDetViewModel.moreDetDto.getOrAwaitValue()
        assertNotNull(moreDetDTO)
        assertTrue(moreDetDTO.certifications.isNotEmpty())
        assertTrue(moreDetDTO.resumeUrl.isNotEmpty())
        assertTrue(moreDetDTO.gitHubUrl.isNotEmpty())
        assertTrue(moreDetDTO.linkedInUrl.isNotEmpty())
        assertTrue(moreDetDTO.blogUrl.isNotEmpty())
    }
}