package com.example.weatherapp.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.BR
import com.example.weatherapp.R
import com.example.weatherapp.databinding.ItemHourBinding
import javax.inject.Inject

/**
 * @author lllhr
 * @date 5/28/2021
 */
class HourAdapter @Inject constructor() :
    RecyclerView.Adapter<HourAdapter.HourViewHolder>() {

    var list = mutableListOf<BindByIdResponse>()

    lateinit var binding: ItemHourBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourViewHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_hour, parent, false)
        return HourViewHolder(binding)
    }

    override fun getItemCount() = list.size

    fun add(newList: BindByIdResponse) {
        list.clear()
        list.add(newList)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: HourViewHolder, position: Int) {

        val model = list[position]
        val forecastList = model.responseById.list[position]

        holder.bind(model)
        holder.bindForecastList(forecastList)
    }


    class HourViewHolder(private val binding: ItemHourBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(obj: Any?) {
            binding.setVariable(BR.weather, obj)
            binding.executePendingBindings()
        }

        fun bindForecastList(obj: Any?) {
            binding.setVariable(BR.forecastList, obj)
            binding.executePendingBindings()
        }

    }

}