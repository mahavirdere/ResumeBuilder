package com.tech.resume_services.dto

data class MoreDetailsDTO(
    val certifications: Array<String>,
    val gitHubUrl: String,
    val linkedInUrl: String,
    val blogUrl: String,
    val resumeUrl: String
)