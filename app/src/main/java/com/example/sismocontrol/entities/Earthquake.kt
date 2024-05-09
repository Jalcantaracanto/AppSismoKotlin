package com.example.sismocontrol.entities

data class Earthquake(
    val id: String,
    val location: String,
    val magnitude: String,
    val time: Long = 0,
    val longitude: Double = 0.0,
    val latitude: Double = 0.0
) {
    companion object {
        val dataEarthquakes = mutableListOf<Earthquake>(
            Earthquake(id = "e1", location = "Vina del Mar - Chile", magnitude = "4.2"),
            Earthquake(id = "e2", location = "Los Andes - Chile", magnitude = "4.8"),
            Earthquake(id = "e3", location = "La Calera - Chile", magnitude = "3.2"),
            Earthquake(id = "e4", location = "Putaendo - Chile", magnitude = "5.4"),
            Earthquake(id = "e5", location = "Curico - Chile", magnitude = "4.2"),
            Earthquake(id = "e6", location = "Talca - Chile", magnitude = "2.2"),
            Earthquake(id = "e7", location = "San Vicente - Chile", magnitude = "6.6"),
            Earthquake(id = "e8", location = "Concepcion - Chile", magnitude = "3.4"),
            Earthquake(id = "e9", location = "Arica - Chile", magnitude = "5.8"),
            Earthquake(id = "e10", location = "Valparaiso - Chile", magnitude = "4.0"),
        )

        val dataEmpty = mutableListOf<Earthquake>()
    }
}