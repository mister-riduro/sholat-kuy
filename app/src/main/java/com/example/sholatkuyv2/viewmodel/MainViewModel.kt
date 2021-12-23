package com.example.sholatkuyv2.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sholatkuyv2.model.SemuaKota
import com.example.sholatkuyv2.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {

    val myResponse: MutableLiveData<SemuaKota> = MutableLiveData()

//    suspend fun getAllCities() {
//        viewModelScope.launch {
//            val response: Response<List<SemuaKota>> = repository.getAllCities()
//            myResponse = response
//        }
//    }

}