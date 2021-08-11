package com.tech.resumebuilder.ui.experience

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tech.resume_services.dto.ProjectDTO
import com.tech.resumebuilder.R
import com.tech.resumebuilder.ui.experience.projectDetails.ProjectDetailsFragmentDirections
import com.tech.resumebuilder.ui.skills.Skill
import com.tech.resumebuilder.ui.skills.SkillsAdapter
import dagger.hilt.android.AndroidEntryPoint
import java.util.ArrayList

@AndroidEntryPoint
class ExperienceFragment : Fragment() {

    private val experienceViewModel: ExperienceViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_experience, container, false)
        val rvProjects: RecyclerView = root.findViewById(R.id.projectsRecycler)
        experienceViewModel.projectList.observe(viewLifecycleOwner, Observer {
            rvProjects.adapter = ProjectsAdapter(it, this)
            rvProjects.layoutManager = LinearLayoutManager(this.context)
        })
        return root
    }

    fun showProjectDetail(project:ProjectDTO){
        val action = ExperienceFragmentDirections.actionNavigationExperienceToNavigationProjDet(project.title,project.desc,project.duration,project.role,project.technologyUsed)
//        findNavController().navigate(R.id.action_navigation_experience_to_navigation_proj_det)
        findNavController().navigate(action)
    }
}