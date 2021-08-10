package com.tech.resumebuilder.ui.skills

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tech.resumebuilder.R

class SkillsAdapter(
    var skillsList: List<Skill>
) : RecyclerView.Adapter<SkillsAdapter.SkillsViewHolder>() {

    inner class SkillsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun skillName() = itemView.findViewById<TextView>(R.id.skillText)

        fun skillRating() = itemView.findViewById<RatingBar>(R.id.skillRating)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_skills, parent, false)
        return SkillsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return skillsList.size
    }

    override fun onBindViewHolder(holder: SkillsViewHolder, position: Int) {
        if (skillsList != null) {
            holder.skillName().text = skillsList[position].skillName
            holder.skillRating().rating = skillsList[position].skillRating
        }
    }
}