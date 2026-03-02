package com.example.meetingefficiencytracker.model

data class Meeting(
    val title: String,      // Nama rapat
    val duration: String,   // Durasi (Teks)
    val participants: Int,  // Jumlah peserta (Angka)
    val isEfficient: Boolean // Status efisien (True/False)
)