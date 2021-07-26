package com.tech.resumebuilder.ui.experience

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.tech.resumebuilder.R

class ExperienceFragment : Fragment() {

    private lateinit var experienceViewModel: ExperienceViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        experienceViewModel =
                ViewModelProvider(this).get(ExperienceViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_experience, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)
        experienceViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}