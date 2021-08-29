package com.tech.resumebuilder

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.tech.resume_services.ResumeRepository
import com.tech.resume_services.ResumeRepositoryTestImpl
import com.tech.resume_services.dto.ProfileDTO
import com.tech.resume_services.dto.SkillsDTO
import com.tech.resumebuilder.ui.home.HomeViewModel
import com.tech.resumebuilder.ui.skills.SkillsViewModel
import junit.framework.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class SkillsViewModelTest {

    private lateinit var skillsViewModel: SkillsViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()


    @Before
    fun initViewModel() {
        val resumeRepo:ResumeRepository = ResumeRepositoryTestImpl()
        skillsViewModel = SkillsViewModel(resumeRepo)
    }

    @Test
    fun `Check Skills Exists`(){
        val skillsDto: List<SkillsDTO> = skillsViewModel.skillList.getOrAwaitValue()
        assertNotNull(skillsDto)
        assertTrue(skillsDto.isNotEmpty())
    }
}