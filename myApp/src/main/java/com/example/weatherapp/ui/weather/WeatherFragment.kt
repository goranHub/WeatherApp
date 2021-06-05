package com.example.weatherapp.ui.weather

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
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentWeatherBinding
import com.example.weatherapp.ui.search.SearchDialog
import com.example.weatherapp.utils.REQUEST_FINE_LOCATION_PERMISSIONS_REQUEST_CODE
import com.example.weatherapp.utils.hasPermission
import com.example.weatherapp.utils.requestPermissionWithRationale
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.CancellationTokenSource
import com.google.android.gms.tasks.Task
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.disposables.CompositeDisposable

/**
 * @author lllhr
 * @date 5/28/2021
 */
@AndroidEntryPoint
class WeatherFragment : Fragment() {

    private lateinit var binding: FragmentWeatherBinding
    lateinit var searchDialog: SearchDialog
    private val disposable = CompositeDisposable()

    private val fusedLocationClient by lazy {
        LocationServices.getFusedLocationProviderClient(activity?.applicationContext)
    }
    private var cancellationTokenSource = CancellationTokenSource()
    private val viewModel: WeatherVM by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        searchDialog = SearchDialog{ it->
            Log.d("tago", it)
            viewModel.byCityName(it, disposable)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWeatherBinding.inflate(inflater)
        binding.locationList.adapter = viewModel.byLocationAdapter
        binding.hourList.adapter = viewModel.hourAdapter
        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.menu_refresh) {
            locationRequestOnClick()
        }
        if (id == R.id.action_search) {
            searchDialog.show(requireActivity().supportFragmentManager, searchDialog.tag)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun locationRequestOnClick() {
        val permissionApproved =
            activity?.hasPermission(Manifest.permission.ACCESS_FINE_LOCATION)

        if (permissionApproved == true) {
            requestCurrentLocation()
        } else {
            requestPermissionWithRationale(
                Manifest.permission.ACCESS_FINE_LOCATION,
                REQUEST_FINE_LOCATION_PERMISSIONS_REQUEST_CODE,
                fineLocationRationalSnackbar
            )
        }
    }

    private val fineLocationRationalSnackbar by lazy {
        Snackbar.make(
            requireActivity().findViewById(android.R.id.content),
            R.string.fine_location_permission_rationale,
            Snackbar.LENGTH_LONG
        ).setAction(R.string.ok) {
            requestPermissions(
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                REQUEST_FINE_LOCATION_PERMISSIONS_REQUEST_CODE
            )
        }
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
                    viewModel.byLocation(location, disposable)
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
