package com.akshay_apps.weather

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest

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
    lateinit var weatherType: TextView
    lateinit var cityFinder: Button

    lateinit var locationManager: LocationManager
    lateinit var locationListener: LocationListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        weatherIcon = findViewById(R.id.weather_icon)
        nameOfCity = findViewById(R.id.location)
        temperature = findViewById(R.id.temperature)
        weatherType = findViewById(R.id.weather)
        cityFinder = findViewById(R.id.searchCity)
    }

    fun findCity(view: View) {
        val intent = Intent(this, CityFinder::class.java)
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        getWeatherForCurrentLocation()
    }

    private fun getWeatherForCurrentLocation() {

        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        locationListener = object:LocationListener {
            override fun onLocationChanged(location: Location) {
                val latitude: String = location.latitude.toString()
                val longitude: String = location.longitude.toString()

                // Instantiate the RequestQueue.
                val url = WEATHER_URL

//// Request a string response from the provided URL.
//                val stringRequest = StringRequest(
//                    Request.Method.GET, url, null
//                    Response.Listener { response ->
//                        var params: Map<String, String> = HashMap()
//                        params.put("lat", latitude)
//                        params.put("lon", longitude)
//                    },
//                    Response.ErrorListener { })
//
//// Add the request to the RequestQueue.
//                MySingleton.getInstance(this).addToRequestQueue(stringRequest)


            }
        }

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }
        locationManager.requestLocationUpdates(LOCATION_PROVIDER, MIN_TIME, MIN_DISTANCE, locationListener)
    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(requestCode == REQUEST_CODE)
        {
            if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(this, "Successfully acquired location", Toast.LENGTH_SHORT).show()
                getWeatherForCurrentLocation()
            }

            else
            {
                //user denied the permission
            }
        }

    }
}