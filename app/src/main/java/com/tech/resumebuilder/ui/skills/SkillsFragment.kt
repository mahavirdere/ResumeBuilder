package com.tech.resumebuilder.ui.skills

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.tech.resumebuilder.R

class SkillsFragment : Fragment() {

    private lateinit var skillsViewModel: MoreDetailsViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        skillsViewModel =
                ViewModelProvider(this).get(MoreDetailsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_skills, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        skillsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}