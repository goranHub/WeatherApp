package com.example.weatherapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.weatherapp.databinding.FragmentWeatherBinding
import com.example.weatherapp.di.Injection
import io.reactivex.disposables.CompositeDisposable

/**
 * @author lllhr
 * @date 5/28/2021
 */
class WeatherFragment : Fragment() {

    private lateinit var binding: FragmentWeatherBinding
    private lateinit var viewModelFactory : ViewModelFactory
    private lateinit var adapter: WeatherAdapter
    private val weatherVM: WeatherVM by viewModels { viewModelFactory }
    private val disposable = CompositeDisposable()

    override fun onStart() {
        super.onStart()
        weatherVM.subscribeOnCurrentWeatherByCityNameFromApiAndSaveItIntoDb(disposable)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModelFactory = Injection.provideViewModelFactory(requireContext())
        adapter = WeatherAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentWeatherBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = adapter
    }

    override fun onStop() {
        disposable.clear()
        super.onStop()
    }

}