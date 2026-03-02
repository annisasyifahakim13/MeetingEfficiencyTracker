package com.example.meetingefficiencytracker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.meetingefficiencytracker.adapter.MeetingAdapter
import com.example.meetingefficiencytracker.model.Meeting

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvMeeting = findViewById<RecyclerView>(R.id.rvMeeting)

        // JANGAN tertukar urutannya: Nama, Durasi, Angka Peserta, Status Efisien
        val meetings = listOf(
            Meeting("Daily Standup", "15 Menit", 5, true),
            Meeting("Sprint Review", "60 Menit", 10, false),
            Meeting("Strategy Planning", "90 Menit", 8, true),
            Meeting("Client Pitch", "45 Menit", 3, true),
            Meeting("Budgeting", "120 Menit", 4, false)
        )

        rvMeeting.layoutManager = LinearLayoutManager(this)
        rvMeeting.adapter = MeetingAdapter(meetings)
    }
}