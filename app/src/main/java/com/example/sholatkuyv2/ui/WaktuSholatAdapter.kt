package com.example.sholatkuyv2.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sholatkuyv2.databinding.ItemWaktuSholatBinding
import com.example.sholatkuyv2.model.WaktuSholat

class WaktuSholatAdapter (
    var waktuSholat: List<WaktuSholat>
        ) : RecyclerView.Adapter<WaktuSholatAdapter.WaktuSholatViewHolder>(){
    inner class WaktuSholatViewHolder(val binding: ItemWaktuSholatBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WaktuSholatViewHolder {
        val binding = ItemWaktuSholatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WaktuSholatViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WaktuSholatViewHolder, position: Int) {
        with(holder.binding) {
            tvWaktuSholat.text = waktuSholat[position].waktuSholat
            tvNamaSholat.text = waktuSholat[position].namaSholat
        }
    }

    override fun getItemCount(): Int {
        return waktuSholat.size
    }
}