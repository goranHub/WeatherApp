package com.example.weatherapp.ui.current

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentWeatherBinding
import com.example.weatherapp.domain.MyLocationManager
import com.example.weatherapp.domain.Repository
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * @author lllhr
 * @date 5/28/2021
 */
@AndroidEntryPoint
class WeatherFragment : Fragment() {

    private lateinit var binding: FragmentWeatherBinding
    private val disposable = CompositeDisposable()


    @Inject
    lateinit var adapter: WeatherAdapter

    @Inject
    lateinit var myLocationManager: MyLocationManager

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

        adapter = WeatherAdapter()

        adapter = WeatherAdapter()

        viewModel.locationListFromDB()

        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.menu_refresh) {
            myLocationManager.startLocationUpdates()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onStop() {
        disposable.clear()
        super.onStop()
    }

}
