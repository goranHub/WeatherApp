package com.example.current

import android.Manifest
import android.annotation.SuppressLint
import android.location.Location
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.weatherapp.databinding.FragmentWeatherBinding
import com.example.common.utils.hasPermission
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.CancellationTokenSource
import com.google.android.gms.tasks.Task
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.disposables.CompositeDisposable

/**
 * @author lllhr
 * @date 5/28/2021
 */
@AndroidEntryPoint
class WeatherFragment : Fragment() {

    private lateinit var binding: FragmentWeatherBinding
    private val disposable = CompositeDisposable()

    private val fusedLocationClient: FusedLocationProviderClient by lazy {
        LocationServices.getFusedLocationProviderClient(activity?.applicationContext)
    }

    private var cancellationTokenSource = CancellationTokenSource()


    private val viewModel: WeatherVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWeatherBinding.inflate(inflater)
        binding.recyclerView.adapter = viewModel.adapter
        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.menu_refresh) {
            requestCurrentLocation()
        }
        return super.onOptionsItemSelected(item)
    }


    @SuppressLint("MissingPermission")
    private fun requestCurrentLocation() {

        if (activity?.applicationContext!!.hasPermission(Manifest.permission.ACCESS_FINE_LOCATION)) {

            val currentLocationTask: Task<Location> = fusedLocationClient.getCurrentLocation(
                LocationRequest.PRIORITY_HIGH_ACCURACY,
                cancellationTokenSource.token
            )

            currentLocationTask.addOnCompleteListener { task: Task<Location> ->
                if (task.isSuccessful && task.result != null) {
                    val location: Location = task.result
                    //api call by current location
                    viewModel.byLocation(
                        location,
                        disposable
                    )
                } else {
                    val exception = task.exception
                    if (exception != null) {
                        Log.e("WeatherFragment", exception.localizedMessage)
                    }
                }
            }
        }
    }

    override fun onStop() {
        disposable.clear()
        cancellationTokenSource.cancel()
        super.onStop()
    }

}
