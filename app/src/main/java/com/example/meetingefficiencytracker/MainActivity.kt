package com.example.meetingefficiencytracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.meetingefficiencytracker.ui.theme.MeetingEfficiencyTrackerTheme
import com.example.meetingefficiencytracker.MeetingScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MeetingEfficiencyTrackerTheme {
                MeetingScreen()
            }
        }
    }
}