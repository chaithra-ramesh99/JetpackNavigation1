package com.example.jetpacknavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpacknavigation.Hiltmodule.MainViewmodel
import com.example.jetpacknavigation.Hiltmodule.crypoAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel:MainViewmodel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      /*  viewModel.cryptoCurrency.observe(this) {
            viewModel.cryptoCurrency.observe(this) {
                val cryptocurrencyList = findViewById<RecyclerView>(R.id.cryptocurrency_list)
                cryptocurrencyList.layoutManager = LinearLayoutManager(this)
                cryptocurrencyList.adapter = CryptocurrencyAdapter(it)
            }
        }*/


        viewModel.cryptocurency.observe(this)
        {
            val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
            recyclerview.layoutManager = LinearLayoutManager(this)
            recyclerview.adapter = crypoAdapter(it)
        }
    }
}