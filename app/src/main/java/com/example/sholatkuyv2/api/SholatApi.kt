package com.example.sholatkuyv2.api

import com.example.sholatkuyv2.model.SemuaKota
import retrofit2.Response
import retrofit2.http.GET

interface SholatApi {

    @GET("sholat/kota/semua")
    suspend fun getAllCities(): Response<List<SemuaKota>>

}