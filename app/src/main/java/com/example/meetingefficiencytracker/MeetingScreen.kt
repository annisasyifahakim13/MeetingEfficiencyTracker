package com.example.meetingefficiencytracker

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MeetingScreen(
    viewModel: MeetingViewModel = viewModel(),
    onBack: () -> Unit
) {
    val title by viewModel.meetingTitle.collectAsState()
    val duration by viewModel.duration.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Meeting Tracker") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Tambah Meeting Baru", style = MaterialTheme.typography.titleMedium)
                    Spacer(modifier = Modifier.height(12.dp))

                    OutlinedTextField(
                        value = title,
                        onValueChange = { viewModel.updateTitle(it) },
                        label = { Text("Judul Meeting") },
                        modifier = Modifier.fillMaxWidth(),
                        enabled = !isLoading
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedTextField(
                        value = duration,
                        onValueChange = { viewModel.updateDuration(it) },
                        label = { Text("Durasi (menit)") },
                        modifier = Modifier.fillMaxWidth(),
                        enabled = !isLoading
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(modifier = Modifier.fillMaxWidth()) {
                        OutlinedButton(
                            onClick = { viewModel.clearMeeting() },
                            modifier = Modifier.weight(1f),
                            enabled = !isLoading
                        ) {
                            Text("Reset")
                        }

                        Spacer(modifier = Modifier.width(8.dp))

                        Button(
                            onClick = {
                                viewModel.saveMeeting { savedTitle ->
                                    scope.launch {
                                        snackbarHostState.showSnackbar("Berhasil menyimpan: $savedTitle")
                                    }
                                }
                            },
                            modifier = Modifier.weight(1f),
                            enabled = !isLoading && title.isNotBlank()
                        ) {
                            if (isLoading) {
                                CircularProgressIndicator(
                                    modifier = Modifier.size(20.dp),
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    strokeWidth = 2.dp
                                )
                            } else {
                                Text("Simpan")
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Daftar Meeting Terkini",
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.titleMedium
            )

            Card(
                modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                ListItem(
                    headlineContent = { Text("Daily Standup") },
                    supportingContent = { Text("15 Menit • 5 Peserta") },
                    trailingContent = { Text("09:00") }
                )
            }
        }
    }
}