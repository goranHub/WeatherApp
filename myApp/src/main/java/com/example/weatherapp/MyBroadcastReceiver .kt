package com.example.weatherapp


import android.app.ActivityManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.annotation.CallSuper
import com.example.weatherapp.data.database.MyLocationEntity
import com.example.weatherapp.domain.Repository
import com.google.android.gms.location.LocationAvailability
import com.google.android.gms.location.LocationResult
import dagger.hilt.android.AndroidEntryPoint
import java.util.Date
import javax.inject.Inject

private const val TAG = "MyBroadcastReceiver "


abstract class HiltBroadcastReceiver : BroadcastReceiver() {
    @CallSuper
    override fun onReceive(context: Context, intent: Intent) {}
}


@AndroidEntryPoint
class MyBroadcastReceiver() : HiltBroadcastReceiver() {

    @Inject
    lateinit var repository : Repository


    override fun onReceive(context: Context, intent: Intent) {
        super.onReceive(context, intent)

        if (intent.action == ACTION_PROCESS_UPDATES) {

            // Checks for location availability changes.
            LocationAvailability.extractLocationAvailability(intent)?.let { locationAvailability ->
                if (!locationAvailability.isLocationAvailable) {
                    Log.d(TAG, "Location services are no longer available!")
                }
            }

            LocationResult.extractResult(intent)?.let { locationResult ->
                val locations = locationResult.locations.map { location ->
                    MyLocationEntity(
                        latitude = location.latitude,
                        longitude = location.longitude,
                        foreground = isAppInForeground(context),
                        date = Date(location.time)
                    )
                }
                if (locations.isNotEmpty()) {
                    repository.addLocations(locations)
                }
            }
        }
    }

    private fun isAppInForeground(context: Context): Boolean {
        val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val appProcesses = activityManager.runningAppProcesses ?: return false

        appProcesses.forEach { appProcess ->
            if (appProcess.importance ==
                ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND &&
                appProcess.processName == context.packageName) {
                return true
            }
        }
        return false
    }

    companion object {
        const val ACTION_PROCESS_UPDATES =
            "com.example.weatherapp.MyBroadcastReceiver.ACTION_PROCESS_UPDATES"
    }
}