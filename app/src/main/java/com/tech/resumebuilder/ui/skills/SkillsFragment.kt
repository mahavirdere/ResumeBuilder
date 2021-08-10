package com.tech.resumebuilder.ui.skills

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tech.resumebuilder.R
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class SkillsFragment : Fragment() {

    private val skillsViewModel: SkillsViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_skills, container, false)
        val rvSkills: RecyclerView = root.findViewById(R.id.skillsRecycler)

        skillsViewModel.skillList.observe(viewLifecycleOwner, Observer {
            val sList = ArrayList<Skill>()
            it.forEach {
                sList.add(Skill(it.skillName, it.skillRating))
            }
            rvSkills.adapter = SkillsAdapter(sList)
            rvSkills.layoutManager = LinearLayoutManager(this.context)
        })
        return root
    }
}