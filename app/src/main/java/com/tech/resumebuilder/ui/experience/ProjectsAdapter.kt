package com.tech.resumebuilder.ui.experience

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.tech.resume_services.dto.ProjectDTO
import com.tech.resumebuilder.R

class ProjectsAdapter(
    var projectList: List<ProjectDTO>, val expFragment: ExperienceFragment
) : RecyclerView.Adapter<ProjectsAdapter.ProjectsViewHolder>() {

    inner class ProjectsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun projTitle() = itemView.findViewById<TextView>(R.id.projectTitle)

        fun viewProjectBtn() = itemView.findViewById<ImageButton>(R.id.viewProjectBtn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_projects, parent, false)
        return ProjectsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return projectList.size
    }

    override fun onBindViewHolder(holder: ProjectsViewHolder, position: Int) {
        if (projectList != null) {
            holder.projTitle().text = projectList[position].title
            holder.viewProjectBtn().setOnClickListener {
                Log.i("@ResumeBuilder","Item Clicked $position")
                expFragment.showProjectDetail(projectList[position])
            }
        }
    }
}