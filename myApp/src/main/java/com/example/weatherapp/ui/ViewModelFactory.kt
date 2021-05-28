package com.example.weatherapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapp.domain.Repository

/**
 * Factory for ViewModels
 */
class ViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WeatherVM::class.java)) {
            return WeatherVM(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
