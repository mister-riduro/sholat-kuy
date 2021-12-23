package com.example.sholatkuyv2.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sholatkuyv2.databinding.FragmentWaktuSholatBinding
import com.example.sholatkuyv2.model.WaktuSholat
import java.text.SimpleDateFormat
import java.util.*


class WaktuSholatFragment : Fragment() {

    private var _binding: FragmentWaktuSholatBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentWaktuSholatBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()

        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val currentDate = sdf.format(Date())

        binding.tvTanggal.text = currentDate

        binding.tvBtnUbah.setOnClickListener {
            val intent = Intent(activity, UbahLokasiActivity::class.java)
            startActivity(intent)
        }
    }

    fun setupRecyclerView() {
        val waktuSholat = mutableListOf(
            WaktuSholat("Imsak", "04:13"),
            WaktuSholat("Subuh", "04:23"),
            WaktuSholat("Terbit", "05:41"),
            WaktuSholat("Dhuha", "06:10"),
            WaktuSholat("Dzuhur", "11:38"),
            WaktuSholat("Ashar", "14:57"),
            WaktuSholat("Maghrib", "17:27"),
            WaktuSholat("Isya'", "18:42"),
        )

        val adapter = WaktuSholatAdapter(waktuSholat)
        binding.rvWaktuSholat.adapter = adapter
        binding.rvWaktuSholat.layoutManager = LinearLayoutManager(context)
    }

}