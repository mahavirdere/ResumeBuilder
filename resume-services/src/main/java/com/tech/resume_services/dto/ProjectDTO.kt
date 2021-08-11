package com.tech.resume_services.dto

data class ProjectDTO(
    val id: Int,
    val title: String,
    val desc: String,
    val duration: String,
    val role: String,
    val technologyUsed: String
)