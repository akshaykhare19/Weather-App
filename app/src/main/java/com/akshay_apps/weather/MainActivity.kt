package com.akshay_apps.weather

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.location.LocationProvider
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.*
import androidx.core.app.ActivityCompat
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.LocationServices.getFusedLocationProviderClient
import com.google.android.gms.location.LocationSettingsRequest
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

//    val APP_ID = "bb8c5b86d505d135e35bf57ba38b45b0"
//    val WEATHER_URL = "https://home.openweathermap.org/data/2.5/weather"
//
//    val MIN_TIME: Long = 5000
//    val MIN_DISTANCE = 1000F
//    val REQUEST_CODE = 101
//
//    val LOCATION_PROVIDER = LocationManager.GPS_PROVIDER
    private lateinit var fusedLocationClient: FusedLocationProviderClient
//
//    lateinit var weatherIcon: ImageView
//    lateinit var nameOfCity: TextView
//    lateinit var temperature: TextView
//    lateinit var weatherType: TextView
//    lateinit var cityFinder: Button
//
//    lateinit var locationManager: LocationManager
//    lateinit var locationListener: LocationListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

//
//        weatherIcon = findViewById(R.id.weather_icon)
//        nameOfCity = findViewById(R.id.location)
//        temperature = findViewById(R.id.temperature)
//        weatherType = findViewById(R.id.weather)
//        cityFinder = findViewById(R.id.searchCity)

    }

//    fun findCity(view: View) {
//        val intent = Intent(this, CityFinder::class.java)
//        startActivity(intent)
//    }

    override fun onResume() {
        super.onResume()
        getWeatherForCurrentLocation()
    }

    private fun getWeatherForCurrentLocation() {

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }
        fusedLocationClient.lastLocation.
        addOnSuccessListener { location: Location ->

        }

//        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
//        locationListener = object:LocationListener {
//            override fun onLocationChanged(location: Location) {
//                val latitude: String = location.latitude.toString()
//                val longitude: String = location.longitude.toString()
//
//                Log.d("latitude", latitude)
//                Log.d("longitude", longitude)



//                var volleyRequestQueue: RequestQueue? = null
//                var dialog: ProgressDialog? = null
//                val serverAPIURL: String = "https://handyopinion.com/tutorials/signup.php"
//                val TAG = "Handy Opinion Tutorials"
//
//                fun SendSignUpDataToServer(firstName: String, lastName: String, email: String, password: String) {
//                    volleyRequestQueue = Volley.newRequestQueue(this@MainActivity)
//                    dialog = ProgressDialog.show(this, "", "Please wait...", true);
//                    val parameters: MutableMap<String, String> = HashMap()
//                    // Add your parameters in HashMap
//                    parameters.put("firstName",firstName);
//                    parameters.put("lastName",lastName);
//                    parameters.put("email",email);
//                    parameters.put("password",password);
//
//                    val strReq: StringRequest = object : StringRequest(
//                            Method.POST,serverAPIURL,
//                            Response.Listener { response ->
//                                Log.e(TAG, "response: " + response)
//                                dialog?.dismiss()
//
//                                // Handle Server response here
//                                try {
//                                    val responseObj = JSONObject(response)
//                                    val isSuccess = responseObj.getBoolean("isSuccess")
//                                    val code = responseObj.getInt("code")
//                                    val message = responseObj.getString("message")
//                                    if (responseObj.has("data")) {
//                                        val data = responseObj.getJSONObject("data")
//                                        // Handle your server response data here
//                                    }
//                                    Toast.makeText(this,message,Toast.LENGTH_LONG).show()
//
//                                } catch (e: Exception) { // caught while parsing the response
//                                    Log.e(TAG, "problem occurred")
//                                    e.printStackTrace()
//                                }
//                            },
//                            Response.ErrorListener { volleyError -> // error occurred
//                                Log.e(TAG, "problem occurred, volley error: " + volleyError.message)
//                            }) {
//
//                        override fun getParams(): MutableMap<String, String> {
//                            return parameters;
//                        }
//
//                        @Throws(AuthFailureError::class)
//                        override fun getHeaders(): Map<String, String> {
//
//                            val headers: MutableMap<String, String> = HashMap()
//                            // Add your Header paramters here
//                            return headers
//                        }
//                    }
//                    // Adding request to request queue
//                    volleyRequestQueue?.add(strReq)
//                }
//




//                val url = "${WEATHER_URL}?lat=${latitude}&lon=${longitude}&appid=${APP_ID}"
//                var condition: Int
//                val parameters: MutableMap<String, String> = HashMap()
//                parameters["lat"] = latitude
//                parameters["lon"] = longitude
//                parameters["appid"] = APP_ID

//                val stringRequest = StringRequest(Request.Method.POST, url, Response.Listener<String>()
//                        {   response ->
//                            Log.d("my_ response", response)
////                            val output = ""
////                            try {
////
////                            }
//                            nameOfCity.text = response.getString("name")
//                            condition = response.getJSONArray("weather").getJSONObject(0).getInt("id")
//                            temperature.text = response.getJSONObject("main").getString("temp")
//                            weatherType.text = response.getJSONArray("weather").getJSONObject(0).getString("description")
//
//                        },
//
//                        {
//                            makeText(this@MainActivity, "Something went wrong!!!", LENGTH_SHORT).show()
//                        })

//                val queue = Volley.newRequestQueue(applicationContext)
//                queue.add(stringRequest)
            }

    fun createLocationRequest() {
        val locationRequest = LocationRequest.create()?.apply {
            interval = 10000
            fastestInterval = 5000
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY

        }
        val builder = LocationSettingsRequest.Builder().addLocationRequest(locationRequest)
    }


        }



//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            //    ActivityCompat#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
//            return
//        }
//        locationManager.requestLocationUpdates(LOCATION_PROVIDER, MIN_TIME, MIN_DISTANCE, locationListener)
//    }
//
//
//    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//
//        if(requestCode == REQUEST_CODE)
//        {
//            if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)
//            {
//                makeText(this, "Successfully acquired location", LENGTH_SHORT).show()
//                getWeatherForCurrentLocation()
//            }
//
//            else
//            {
//                //user denied the permission
//            }
//        }
//
//    }
//}