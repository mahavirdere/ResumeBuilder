package com.tech.resumebuilder.ui.moreDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.tech.resumebuilder.R
import com.tech.resumebuilder.ui.skills.MoreDetailsViewModel

class MoreDetailsFragment : Fragment() {

    private lateinit var moreDetailsViewModel: MoreDetailsViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        moreDetailsViewModel =
                ViewModelProvider(this).get(MoreDetailsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_skills, container, false)
//        val textView: TextView = root.findViewById(R.id.text_dashboard)
//        moreDetailsViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        return root
    }
}