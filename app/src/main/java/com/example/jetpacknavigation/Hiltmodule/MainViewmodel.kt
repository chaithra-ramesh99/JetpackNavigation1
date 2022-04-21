package com.example.jetpacknavigation.Hiltmodule

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewmodel @Inject constructor(val crypocurrencyRepo: CrypocurrencyRepo):ViewModel() {

    private val cryptocurrencyEmitter = MutableLiveData<List<Cryptocurency>>()
    val cryptocurency:LiveData<List<Cryptocurency>> = cryptocurrencyEmitter

    init {
        loadCryptocurerncy()
    }

    private fun loadCryptocurerncy() {
        cryptocurrencyEmitter.value =  crypocurrencyRepo.getCryptocurrency()
    }

}