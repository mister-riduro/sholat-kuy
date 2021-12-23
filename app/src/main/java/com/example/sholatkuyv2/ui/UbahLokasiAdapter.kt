package com.example.sholatkuyv2.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.sholatkuyv2.databinding.ItemLokasiBinding
import com.example.sholatkuyv2.model.SemuaKota

class UbahLokasiAdapter: RecyclerView.Adapter<UbahLokasiAdapter.UbahLokasiViewHolder>() {
    inner class UbahLokasiViewHolder(val binding: ItemLokasiBinding): RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<SemuaKota>() {
        override fun areItemsTheSame(oldItem: SemuaKota, newItem: SemuaKota): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: SemuaKota, newItem: SemuaKota): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)
    private var onItemClickListener: ((SemuaKota) -> Unit)? = null

    var semuaKota: List<SemuaKota>
    get() = differ.currentList
    set(value) {
        differ.submitList(value)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UbahLokasiViewHolder {
        return UbahLokasiViewHolder(ItemLokasiBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        ))
    }

    override fun onBindViewHolder(holder: UbahLokasiViewHolder, position: Int) {
        holder.binding.apply {
            val loc = semuaKota[position]
            tvRvKota.text = loc.lokasi
        }
    }

    override fun getItemCount(): Int {
        return semuaKota.size
    }

    fun setOnItemClickListener(listener: (SemuaKota) -> Unit) {
        onItemClickListener = listener
    }
}