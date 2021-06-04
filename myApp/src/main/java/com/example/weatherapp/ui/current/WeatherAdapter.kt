package com.example.weatherapp.ui.current

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.BR
import com.example.weatherapp.R
import com.example.weatherapp.data.model.WeatherByCityModel
import com.example.weatherapp.databinding.ItemCurrentCityWeatherBinding
import javax.inject.Inject

/**
 * @author lllhr
 * @date 5/28/2021
 */
class WeatherAdapter @Inject constructor() :
    RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {

    var list = mutableListOf<BindResponse>()

    lateinit var binding: ItemCurrentCityWeatherBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
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

    fun add(newList: BindResponse) {
        list.clear()
        list.add(newList)
        notifyDataSetChanged()
    }

    class WeatherViewHolder(private val binding: ItemCurrentCityWeatherBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(obj: Any?) {
            binding.setVariable(BR.weather, obj)
            binding.executePendingBindings()
        }
    }

}