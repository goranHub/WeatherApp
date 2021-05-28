package com.example.weatherapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.BR
import com.example.weatherapp.databinding.ItemCurrentCityWeatherBinding
import com.example.weatherapp.domain.BindCurrentCityModel

/**
 * @author lllhr
 * @date 5/28/2021
 */
class WeatherAdapter : RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {

    var list = mutableListOf<BindCurrentCityModel>()


    lateinit var binding : ItemCurrentCityWeatherBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder{
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_current_city_weather, parent, false)

        return WeatherViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val dataModel = list[position]
        holder.bind(dataModel)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class WeatherViewHolder(private val binding : ItemCurrentCityWeatherBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(obj: Any?) {
            binding.setVariable(BR.data, obj)
            binding.executePendingBindings()
        }
    }

}