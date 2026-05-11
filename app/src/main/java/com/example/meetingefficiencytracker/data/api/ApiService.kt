package com.example.meetingefficiencytracker.data.api

import com.example.meetingefficiencytracker.data.model.Meeting
import retrofit2.http.GET

interface ApiService {
    @GET("meeting.json")
    suspend fun getMeetings(): List<Meeting>
}
