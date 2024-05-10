package com.example.sismocontrol.adapters

import android.app.ActionBar.TabListener
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sismocontrol.databinding.EarthquakeItemBinding
import com.example.sismocontrol.entities.Earthquake

private val TAG = EarthquakeAdapter::class.java.simpleName

class EarthquakeAdapter : RecyclerView.Adapter<EarthquakeAdapter.EarthquakeViewHolder>() {

    lateinit var onItemClickListener: (Earthquake) -> Unit

    //Atributo de clase
    var earthquakes = mutableListOf<Earthquake>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EarthquakeAdapter.EarthquakeViewHolder {

        val bindingItem =
            EarthquakeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return EarthquakeViewHolder(bindingItem)
    }

    override fun onBindViewHolder(holder: EarthquakeAdapter.EarthquakeViewHolder, position: Int) {
        val earthquake: Earthquake = earthquakes[position]
        holder.bind(earthquake)
    }

    override fun getItemCount(): Int {
        return earthquakes.size
    }

    inner class EarthquakeViewHolder(private var bindingItem: EarthquakeItemBinding) :
        RecyclerView.ViewHolder(bindingItem.root) {

        fun bind(earthquake: Earthquake) {

            with(earthquake) {
                bindingItem.txtMagnitude.text = magnitude.toString()
                bindingItem.txtLocation.text = location
            }
            bindingItem.root.setOnClickListener {
                if (::onItemClickListener.isInitialized)
                    onItemClickListener(earthquake)
                else
                    Log.e(TAG, "onItemClickList is not initialized")

            }

//            bindingItem.txtMagnitude.text = earthquake.magnitude.toString()
//            bindingItem.txtLocation.text = earthquake.location
        }
    }

}