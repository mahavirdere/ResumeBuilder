package com.tech.resumebuilder.ui.moreDetails

import android.app.DownloadManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.tech.resumebuilder.R
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class MoreDetailsFragment : Fragment() {

    private val moreDetailsViewModel: MoreDetailsViewModel by viewModels()
    private val urlMap = mutableMapOf("GitHub" to "", "LinkedIn" to "", "Blog" to "", "Download" to "")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_more_details, container, false)
        val listView: ListView = root.findViewById(R.id.certsList)
        moreDetailsViewModel.moreDetDto.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            val arrayAdapter =
                ArrayAdapter(requireContext(), R.layout.item_certifications, R.id.lable, it.certifications)
            listView.adapter = arrayAdapter
            urlMap.put("GitHub", it.gitHubUrl)
            urlMap.put("LinkedIn", it.linkedInUrl)
            urlMap.put("Blog", it.blogUrl)
            urlMap.put("Download", it.resumeUrl)
        })

        val imgGitHub: ImageView = root.findViewById(R.id.imgGitHub)
        imgGitHub.setOnClickListener {
            redirectToURL(urlMap["GitHub"])
        }
        val imgLinkedIn: ImageView = root.findViewById(R.id.imgLinkedIn)
        imgLinkedIn.setOnClickListener {
            redirectToURL(urlMap["LinkedIn"])
        }
        val imgBlog: ImageView = root.findViewById(R.id.imgBlog)
        imgBlog.setOnClickListener {
            redirectToURL(urlMap["Blog"])
        }
        val imgBtnDwld: ImageButton = root.findViewById(R.id.imgBtnDwld)
        imgBtnDwld.setOnClickListener {
            it.isClickable = false
            val manager: DownloadManager =
                requireContext().getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            val uri =
                Uri.parse(urlMap["Download"])
            val request = DownloadManager.Request(uri)
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
            val reference: Long = manager.enqueue(request)
            it.isClickable = true
        }
        return root
    }

    fun redirectToURL(url: String?) {
        val uri: Uri = Uri.parse(url)
        startActivity(Intent(Intent.ACTION_VIEW, uri))
    }
}