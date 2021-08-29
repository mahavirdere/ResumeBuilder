package com.tech.resumebuilder

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.tech.resume_services.ResumeRepository
import com.tech.resume_services.ResumeRepositoryTestImpl
import com.tech.resume_services.dto.ProjectDTO
import com.tech.resumebuilder.ui.experience.ExperienceViewModel
import junit.framework.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class ProjectViewModelTest {

    private lateinit var expViewModel: ExperienceViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()


    @Before
    fun initViewModel() {
        val resumeRepo:ResumeRepository = ResumeRepositoryTestImpl()
        expViewModel = ExperienceViewModel(resumeRepo)
    }

    @Test
    fun `Check Projects Exists`(){
        val projectList: List<ProjectDTO> = expViewModel.projectList.getOrAwaitValue()
        assertNotNull(projectList)
        assertTrue(projectList.isNotEmpty())
    }
}