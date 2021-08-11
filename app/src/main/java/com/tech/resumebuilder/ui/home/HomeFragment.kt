package com.tech.resumebuilder.ui.home

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
import com.tech.resumebuilder.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val nameTextView: TextView = root.findViewById(R.id.name_textView)
        val addressTextView: TextView = root.findViewById(R.id.address_textView)
        val dobTextView: TextView = root.findViewById(R.id.dob_textView)
        val nationalityTextView: TextView = root.findViewById(R.id.nationality_textView)
        val hobbiesTextView: TextView = root.findViewById(R.id.hobbies_textView)
        val maritalStatusTextView: TextView = root.findViewById(R.id.marital_status_textView)
        val mobNoTextView: TextView = root.findViewById(R.id.mob_no_textView)

        homeViewModel.profileDto.observe(viewLifecycleOwner, Observer {
            homeViewModel.updateProfileData(it)
        })
        homeViewModel.name.observe(viewLifecycleOwner, Observer {
            nameTextView.text = it
        })
        homeViewModel.address.observe(viewLifecycleOwner, Observer {
            addressTextView.text = it
        })
        homeViewModel.dob.observe(viewLifecycleOwner, Observer {
            dobTextView.text = it
        })
        homeViewModel.nationality.observe(viewLifecycleOwner, Observer {
            nationalityTextView.text = it
        })
        homeViewModel.hobbies.observe(viewLifecycleOwner, Observer {
            hobbiesTextView.text = it
        })
        homeViewModel.maritalStatus.observe(viewLifecycleOwner, Observer {
            maritalStatusTextView.text = it
        })
        homeViewModel.mobNo.observe(viewLifecycleOwner, Observer {
            mobNoTextView.text = it
        })

        val skillsLink: TextView = root.findViewById(R.id.skillsLink)
        val expLink: TextView = root.findViewById(R.id.expLink)
        val mDetLink: TextView = root.findViewById(R.id.mDetLink)
        skillsLink.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_home_to_navigation_skills)
        }
        expLink.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_home_to_navigation_experience)
        }
        mDetLink.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_home_to_navigation_more_details)
        }
        return root
    }
}