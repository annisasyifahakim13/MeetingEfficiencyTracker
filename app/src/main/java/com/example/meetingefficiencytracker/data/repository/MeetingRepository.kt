package com.example.meetingefficiencytracker.data.repository

import com.example.meetingefficiencytracker.data.api.RetrofitClient
import com.example.meetingefficiencytracker.data.model.Meeting

class MeetingRepository {
    private val apiService = RetrofitClient.instance
    suspend fun getMeetings(): List<Meeting> {
        return apiService.getMeetings()
    }
}
