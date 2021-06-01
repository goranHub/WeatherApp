package com.example.current

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.model.model.Weather
import com.example.weatherapp.BR
import com.example.weatherapp.databinding.ItemCurrentCityWeatherBinding
import javax.inject.Inject

/**
 * @author lllhr
 * @date 5/28/2021
 */
class WeatherAdapter @Inject constructor(): RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {

    var list = mutableListOf<Weather>()

    lateinit var binding : ItemCurrentCityWeatherBinding

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

    fun add(newList: List<Weather>?){
        if (newList != null) {
            list.addAll(newList)
            notifyDataSetChanged()
        }
    }

    class WeatherViewHolder(private val binding : ItemCurrentCityWeatherBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(obj: Any?) {
            binding.setVariable(BR.data, obj)
            binding.executePendingBindings()
        }
    }

}