package com.example.sismocontrol

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sismocontrol.adapters.EarthquakeAdapter
import com.example.sismocontrol.databinding.ActivityMainBinding
import com.example.sismocontrol.entities.Earthquake
import java.net.URLEncoder

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

        earthquakeAdapter.earthquakes = Earthquake.dataEarthquakes
        //earthquakeAdapter.earthquakes = Earthquake.dataEmpty
        earthquakeAdapter.onItemClickListener = { earthquake ->
            Toast.makeText(this, earthquake.location, Toast.LENGTH_SHORT).show()

            //sendEmailEarthquake(earthquake)
            sendWhatsappEarthquake(earthquake)
        }

        if (earthquakeAdapter.earthquakes.isEmpty()) {
            binding.txtEmpty.visibility = View.VISIBLE
        } else {
            binding.txtEmpty.visibility = View.GONE
        }

    }

    /**
     * PREGUNTA EXAMEN CERTIFICACION
     */
    private fun sendEmailEarthquake(earthquake: Earthquake) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "message/rfc822"
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("javier.alcantara.canto@gmail.com"))
        intent.putExtra(Intent.EXTRA_SUBJECT, "Earthquake Alarm")
        intent.putExtra(
            Intent.EXTRA_TEXT,
            "hello, I have an earthquake at ${earthquake.location} with magnitude ${earthquake.magnitude}"
        )

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(Intent.createChooser(intent, "Send email"))
        } else {
            Toast.makeText(this, "The email could not be sent", Toast.LENGTH_SHORT).show()
        }
    }

    private fun sendWhatsappEarthquake(earthquake: Earthquake) {

        val telefonoWsp = "56987654321"
        val mensaje =
            "hello, I have an earthquake at ${earthquake.location} with magnitude ${earthquake.magnitude}"
        val uri = Uri.parse("https://api.whatsapp.com/send?phone=$telefonoWsp&text=${URLEncoder.encode(mensaje, "UTF-8")}")

        val intent = Intent(Intent.ACTION_VIEW, uri)

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(Intent.createChooser(intent, "Send whatsapp"))
        } else {
            Toast.makeText(this, "The Whatsapp could not be sent", Toast.LENGTH_SHORT).show()
        }
    }
}