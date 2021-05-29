package com.example.weatherapp.ui.current

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.weatherapp.MainActivity
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentWeatherBinding
import com.example.weatherapp.di.Injection
import com.example.weatherapp.domain.BindLocation
import com.example.weatherapp.domain.Repository
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @author lllhr
 * @date 5/28/2021
 */
class WeatherFragment : Fragment() {

    private lateinit var binding: FragmentWeatherBinding
    private lateinit var bindLocation: BindLocation
    private lateinit var adapter: WeatherAdapter
    private lateinit var viewModel: WeatherVM
    private lateinit var rep: Repository
    private val disposable = CompositeDisposable()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        rep = Injection.provideRepository(requireActivity())
        bindLocation = Injection.provideBindLocation()
        adapter = Injection.provideAdapter()

        viewModel = WeatherVM(rep, bindLocation,adapter)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWeatherBinding.inflate(inflater)
        binding.recyclerView.adapter = adapter

        viewModel.subscribeOnCurrentWeatherByLocationFromApiAndSaveItIntoDb(disposable)

        return binding.root
    }



    override fun onStop() {
        disposable.clear()
        super.onStop()
    }

}
