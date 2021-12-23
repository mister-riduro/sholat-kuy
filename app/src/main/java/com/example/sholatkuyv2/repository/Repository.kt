package com.example.sholatkuyv2.repository

import com.example.sholatkuyv2.api.RetrofitInstance
import com.example.sholatkuyv2.api.RetrofitInstance.api
import com.example.sholatkuyv2.model.SemuaKota
import retrofit2.Response

class Repository {
    suspend fun getAllCities() = api.getAllCities()
}