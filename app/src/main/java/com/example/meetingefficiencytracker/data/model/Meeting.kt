package com.example.meetingefficiencytracker.data.model

import com.google.gson.annotations.SerializedName

data class Meeting(
    @SerializedName("title")
    val title: String,
    @SerializedName("duration")
    val duration: String,
    @SerializedName("participants")
    val participants: Int,
    @SerializedName("image_url")
    val imageUrl: String
)
