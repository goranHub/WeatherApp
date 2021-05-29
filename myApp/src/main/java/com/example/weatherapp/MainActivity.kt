package com.example.weatherapp

import android.Manifest.permission
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.weatherapp.di.Injection
import com.example.weatherapp.domain.BindLocation
import com.example.weatherapp.domain.Repository
import com.example.weatherapp.utils.PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION
import com.google.android.gms.location.*
import kotlinx.android.synthetic.main.activity_main.*


@Suppress("DEPRECATED_IDENTITY_EQUALS")
class MainActivity : AppCompatActivity() {

    private lateinit var bindLocation : BindLocation
    private lateinit var client: FusedLocationProviderClient
    private lateinit var rep: Repository


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rep = Injection.provideRepository(this)

        bindLocation = Injection.provideBindLocation()

        client =
            LocationServices.getFusedLocationProviderClient(this)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_refresh, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.menu_refresh) {
            init()
        }
        return super.onOptionsItemSelected(item)
    }

    fun init() {
        if (ActivityCompat.checkSelfPermission(this, permission.ACCESS_FINE_LOCATION)
            !== PackageManager.PERMISSION_GRANTED && ActivityCompat
                .checkSelfPermission(this, permission.ACCESS_COARSE_LOCATION)
            !== PackageManager.PERMISSION_GRANTED
        ) {
            requestPermission()
            return
        } else {
            client.lastLocation.addOnSuccessListener { location ->
                location?.let {
                    bindLocation.lati  = location.latitude
                    bindLocation.longi  = location.longitude
                }
            }
            Log.e("test", "2")
            rep.weatherApi.searchByCurrentLocation(bindLocation.lati, bindLocation.longi)
        }
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(
            this@MainActivity,
            arrayOf(permission.ACCESS_FINE_LOCATION),
            PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION
        )
    }

}