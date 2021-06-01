package com.example.weatherapp.domain

import android.Manifest
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.weatherapp.MyBroadcastReceiver
import com.example.weatherapp.utils.hasPermission
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.concurrent.TimeUnit
import javax.inject.Inject


private const val TAG = "MyLocationManager"


class MyLocationManager @Inject constructor(@ApplicationContext val context: Context) {

    private val _receivingLocationUpdates: MutableLiveData<Boolean> = MutableLiveData<Boolean>(false)

    val receivingLocationUpdates: LiveData<Boolean>
        get() = _receivingLocationUpdates

    private val fusedLocationClient: FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(context)

    private val locationRequest: LocationRequest = LocationRequest().apply {

        interval = TimeUnit.SECONDS.toMillis(5)
        fastestInterval = TimeUnit.SECONDS.toMillis(1)
        maxWaitTime = TimeUnit.SECONDS.toMillis(10)
        priority = LocationRequest.PRIORITY_HIGH_ACCURACY
    }

    private val locationUpdatePendingIntent: PendingIntent by lazy {
        val intent = Intent(context, MyBroadcastReceiver::class.java)
        intent.action = MyBroadcastReceiver.ACTION_PROCESS_UPDATES
        PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
    }

    @Throws(SecurityException::class)
    @MainThread
    fun startLocationUpdates() {
        Log.d(TAG, "startLocationUpdates()")

        if (!context.hasPermission(Manifest.permission.ACCESS_FINE_LOCATION)) return

        try {
            _receivingLocationUpdates.value = true
            fusedLocationClient.requestLocationUpdates(locationRequest, locationUpdatePendingIntent)
        } catch (permissionRevoked: SecurityException) {
            _receivingLocationUpdates.value = false

            Log.d(TAG, "Location permission revoked; details: $permissionRevoked")
            throw permissionRevoked
        }
    }

    @MainThread
    fun stopLocationUpdates() {
        Log.d(TAG, "stopLocationUpdates()")
        _receivingLocationUpdates.value = false
        fusedLocationClient.removeLocationUpdates(locationUpdatePendingIntent)
    }
}