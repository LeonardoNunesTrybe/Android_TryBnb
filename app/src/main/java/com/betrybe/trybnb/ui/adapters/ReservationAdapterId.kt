package com.betrybe.trybnb.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.betrybe.trybnb.R
import com.betrybe.trybnb.data.models.UrlParameter

class ReservationAdapterId(private val reservationIds: List<UrlParameter>) :
    Adapter<ReservationAdapterId.ReservationIdViewHolder>() {

        class ReservationIdViewHolder(private val view: View) :
        ViewHolder(view) {}

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ReservationIdViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_reservation, parent, false)
        return ReservationIdViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ReservationIdViewHolder,
        position: Int
    ) {
        val reservationIds = reservationIds[position]
    }

    override fun getItemCount(): Int {
        return reservationIds.size
    }

}