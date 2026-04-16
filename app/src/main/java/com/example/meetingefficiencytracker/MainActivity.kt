package com.example.meetingefficiencytracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image // Import untuk Gambar
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale // Agar gambar pas di kotak
import androidx.compose.ui.res.painterResource // Untuk mengambil file drawable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meetingefficiencytracker.ui.theme.MeetingEfficiencyTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeetingEfficiencyTrackerTheme {
                var currentScreen by remember { mutableStateOf("home") }

                if (currentScreen == "home") {
                    DashboardAsliScreen(onJoinClicked = { currentScreen = "tracker" })
                } else {
                    MeetingScreen(onBack = { currentScreen = "home" })
                }
            }
        }
    }
}

@Composable
fun DashboardAsliScreen(onJoinClicked: () -> Unit) {
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Text(
                text = "Meeting Populer",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 12.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                val imagesTop = listOf(R.drawable.meeting1, R.drawable.meeting2, R.drawable.meeting3)
                imagesTop.forEach { imgRes ->
                    Image(
                        painter = painterResource(id = imgRes),
                        contentDescription = null,
                        modifier = Modifier
                            .size(80.dp)
                            .clip(RoundedCornerShape(12.dp)),
                        contentScale = ContentScale.Crop
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Daftar Meeting",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            val titles = listOf("Daily Standup", "Sprint Review", "Strategy Planning")
            val banners = listOf(R.drawable.meeting4, R.drawable.meeting5, R.drawable.meeting1)

            repeat(3) { index ->
                Card(
                    modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = androidx.compose.ui.graphics.Color.White),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column {
                        Image(
                            painter = painterResource(id = banners[index]),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(120.dp),
                            contentScale = ContentScale.Crop
                        )

                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(text = titles[index], fontWeight = FontWeight.Bold, fontSize = 16.sp)
                            Text(text = "Durasi: 15-60 menit • 5 peserta", fontSize = 12.sp, color = androidx.compose.ui.graphics.Color.Gray)

                            Spacer(modifier = Modifier.height(12.dp))

                            Button(
                                onClick = onJoinClicked,
                                modifier = Modifier.fillMaxWidth(),
                                shape = RoundedCornerShape(10.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = androidx.compose.ui.graphics.Color(0xFF1976D2))
                            ) {
                                Text("Join Meeting", color = androidx.compose.ui.graphics.Color.White)
                            }
                        }
                    }
                }
            }
        }
    }
}