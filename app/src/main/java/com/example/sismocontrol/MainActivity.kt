package com.example.sismocontrol

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sismocontrol.adapters.EarthquakeAdapter
import com.example.sismocontrol.databinding.ActivityMainBinding
import com.example.sismocontrol.entities.Earthquake

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerEarthquake.layoutManager = LinearLayoutManager(this)
        initAdapter()
    }

    fun initAdapter() {
        val earthquakeAdapter = EarthquakeAdapter()
        binding.recyclerEarthquake.adapter = earthquakeAdapter
        //earthquakeAdapter.earthquakes = Earthquake.dataEarthquakes

        earthquakeAdapter.earthquakes = Earthquake.dataEmpty

        if (earthquakeAdapter.earthquakes.isEmpty()) {
            binding.txtEmpty.visibility = View.VISIBLE
        } else {
            binding.txtEmpty.visibility = View.GONE
        }

    }
}