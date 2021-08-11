package com.tech.resumebuilder.ui.experience.projectDetails

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.tech.resumebuilder.R

class ProjectDetailsFragment : Fragment() {

    private val args:ProjectDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.project_details_fragment, container, false)
        val titleText: TextView = root.findViewById(R.id.titleText)
        val descText: TextView = root.findViewById(R.id.descText)
        val durationText: TextView = root.findViewById(R.id.durationText)
        val roleText: TextView = root.findViewById(R.id.roleText)
        val techsText: TextView = root.findViewById(R.id.techsText)

        titleText.text = args.title
        descText.text = args.desc
        durationText.text = args.duration
        roleText.text = args.role
        techsText.text = args.technologiesUsed
        return root
    }

}