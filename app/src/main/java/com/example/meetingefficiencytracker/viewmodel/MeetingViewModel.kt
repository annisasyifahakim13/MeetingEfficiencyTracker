package com.example.meetingefficiencytracker

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MeetingViewModel : ViewModel() {
    private val _meetingTitle = MutableStateFlow("")
    val meetingTitle: StateFlow<String> = _meetingTitle.asStateFlow()

    private val _duration = MutableStateFlow("")
    val duration: StateFlow<String> = _duration.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    fun updateTitle(title: String) { _meetingTitle.value = title }
    fun updateDuration(time: String) { _duration.value = time }

    fun clearMeeting() {
        _meetingTitle.value = ""
        _duration.value = ""
    }

    fun saveMeeting(onComplete: (String) -> Unit) {
        viewModelScope.launch {
            _isLoading.value = true
            delay(2000)
            val title = _meetingTitle.value
            _isLoading.value = false
            onComplete(title)
        }
    }
}