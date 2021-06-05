package com.example.weatherapp.ui.search

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import kotlin.properties.Delegates
import com.example.weatherapp.BR
import com.example.weatherapp.data.responseById.ResponseById

class BindByIdResponse(val responseById: ResponseById) : BaseObservable() {

    var iconListUrl = listOf("")

    @get:Bindable
    var imageUrlList :List<String> by Delegates.observable(listOf("")) { _, _, _ -> notifyPropertyChanged(BR.imageUrlList) }

    init {
        val count = responseById.cnt

        responseById.list.forEach {
            it.weather.forEach { weather ->
                iconListUrl.toMutableList()
                    .add("http://openweathermap.org/img/w/${weather.icon}.png")
            }
        }
    }

}
