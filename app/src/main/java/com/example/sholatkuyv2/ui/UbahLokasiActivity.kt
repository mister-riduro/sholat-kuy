package com.example.sholatkuyv2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sholatkuyv2.R
import com.example.sholatkuyv2.api.RetrofitInstance
import com.example.sholatkuyv2.databinding.ActivityUbahLokasiBinding
import retrofit2.HttpException
import java.io.IOException

const val TAG = "UbahLokasiActivity"

class UbahLokasiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUbahLokasiBinding
    private lateinit var ubahLokasiAdapter: UbahLokasiAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityUbahLokasiBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupRecyclerView()

        lifecycleScope.launchWhenCreated {
            val response = try {
                RetrofitInstance.api.getAllCities()
            } catch (e: IOException) {
                Log.e(TAG, "No Internet")
                return@launchWhenCreated
            } catch (e: HttpException) {
                Log.e(TAG, "UnExpected")
                return@launchWhenCreated
            }

            if(response.isSuccessful && response.body() != null) {
                ubahLokasiAdapter.semuaKota = response.body()!!
            } else {
                Log.e(TAG, "Response not successful")
            }
        }
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setHomeAsUpIndicator(R.drawable.ic_back)
        actionBar?.title = "Ubah Lokasi"
    }

    private fun setupRecyclerView() = binding.rvSemuaKota.apply {
        ubahLokasiAdapter = UbahLokasiAdapter()
        adapter = ubahLokasiAdapter
        layoutManager = LinearLayoutManager(this@UbahLokasiActivity)

        ubahLokasiAdapter.setOnItemClickListener {

        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }

        return super.onContextItemSelected(item)
    }
}