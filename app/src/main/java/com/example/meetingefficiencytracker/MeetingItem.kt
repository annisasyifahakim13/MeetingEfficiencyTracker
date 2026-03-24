package com.example.meetingefficiencytracker

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meetingefficiencytracker.model.MeetingData

@Composable
fun MeetingItem(meeting: MeetingData) {

    val context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        shape = RoundedCornerShape(12.dp)
    ) {

        Column(
            modifier = Modifier.padding(12.dp)
        ) {

            Image(
                painter = painterResource(id = meeting.image),
                contentDescription = meeting.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = meeting.title,
                fontSize = 18.sp
            )

            Text(
                text = "Durasi: ${meeting.duration}",
                fontSize = 14.sp
            )

            Text(
                text = "Peserta: ${meeting.participants}",
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    Toast.makeText(
                        context,
                        "Bergabung ke ${meeting.title}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            ) {

                Text("Join Meeting")

            }
        }
    }
}