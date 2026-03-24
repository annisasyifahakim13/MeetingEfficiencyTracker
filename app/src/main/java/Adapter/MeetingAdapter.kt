package com.example.meetingefficiencytracker.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.meetingefficiencytracker.R
import com.example.meetingefficiencytracker.model.Meeting

class MeetingAdapter(private val list: List<Meeting>) : RecyclerView.Adapter<MeetingAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitle: TextView = view.findViewById(R.id.tvTitle)
        val tvDuration: TextView = view.findViewById(R.id.tvDuration)
        val tvParticipants: TextView = view.findViewById(R.id.tvParticipants)

        // PENTING: Daftarkan semua ImageView
        val imgMeeting: ImageView = view.findViewById(R.id.imgMeeting)
        val imgTimer: ImageView = view.findViewById(R.id.imgTimer)
        val imgGroup: ImageView = view.findViewById(R.id.imgGroup)
        val imgIde: ImageView = view.findViewById(R.id.imgIde)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_meeting, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = list[position]
        holder.tvTitle.text = data.title
        holder.tvDuration.text = data.duration
        holder.tvParticipants.text = "Peserta: ${data.participants}"

        // Pasang Gambar dari folder drawable
        holder.imgMeeting.setImageResource(R.drawable.meeting1)
        holder.imgTimer.setImageResource(R.drawable.meeting3)
        holder.imgGroup.setImageResource(R.drawable.meeting4)
        holder.imgIde.setImageResource(R.drawable.meeting5)

        // Logika lampu ide (hanya muncul jika isEfficient = true)
        if (data.isEfficient) {
            holder.imgIde.setImageResource(R.drawable.meeting5)
            holder.imgIde.visibility = View.VISIBLE
        } else {
            holder.imgIde.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int = list.size
}