package com.akshay_apps.weather

import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    val APP_ID = "bb8c5b86d505d135e35bf57ba38b45b0"
    val WEATHER_URL = "https://home.openweathermap.org/data/2.5/weather"

    val MIN_TIME: Long = 5000
    val MIN_DISTANCE = 1000F
    val REQUEST_CODE = 101

    val LOCATION_PROVIDER = LocationManager.GPS_PROVIDER

    lateinit var weatherIcon: ImageView
    lateinit var nameOfCity: TextView
    lateinit var temperature: TextView
    lateinit var weather: TextView
    lateinit var cityFinder: Button

    lateinit var locationManager: LocationManager
    lateinit var locationListener: LocationListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}