package com.example.weatherapp.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.BR
import com.example.weatherapp.R
import com.example.weatherapp.data.responseById.Forecast
import com.example.weatherapp.databinding.ItemHourBinding
import javax.inject.Inject

/**
 * @author lllhr
 * @date 5/28/2021
 */
class HourAdapter @Inject constructor() :
    RecyclerView.Adapter<HourAdapter.HourViewHolder>() {

    var list = mutableListOf<Forecast>()
    lateinit var bindFore: BindForecast
    lateinit var binding: ItemHourBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourViewHolder {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_hour,
            parent,
            false
        )
        return HourViewHolder(binding)
    }


    override fun getItemCount() = list.size



    fun add(bindForecast: BindForecast) {
        list.addAll(bindForecast.forecastList)
        bindFore = bindForecast
        notifyDataSetChanged()
    }


    override fun onBindViewHolder(holder: HourViewHolder, position: Int) {
        val model = list[position]
        holder.bindForecast(model)

        holder.bind(bindFore)
    }


    class HourViewHolder(private val binding: ItemHourBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(obj: Any?) {
            binding.setVariable(BR.bind, obj)
            binding.executePendingBindings()
        }

        fun bindForecast(obj: Any?) {
            binding.setVariable(BR.forecast, obj)
            binding.executePendingBindings()
        }
    }
}