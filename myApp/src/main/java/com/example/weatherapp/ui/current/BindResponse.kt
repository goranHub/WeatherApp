package com.example.weatherapp.ui.current

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.weatherapp.data.model.WeatherByCityModel
import com.example.weatherapp.data.response.ResponseByCity
import com.example.weatherapp.domain.toModel
import kotlin.properties.Delegates
import com.example.weatherapp.BR

class BindResponse(val responseByCity: ResponseByCity?) : BaseObservable() {

    var iconUrl : String
    lateinit var bindModel : WeatherByCityModel

    @get:Bindable
    var imageUrl  by Delegates.observable("") { _, _, _ -> notifyPropertyChanged(BR.imageUrl) }

    init {
        val icon = responseByCity?.weather?.get(0)?.icon
        iconUrl = "http://openweathermap.org/img/w/$icon.png"

        if (responseByCity != null) {
            bindModel = responseByCity.toModel()
            bindModel.icon = iconUrl

            val number =(responseByCity.main?.temp?.minus(273.15))
            val celsius = number?.format(2)
            bindModel.temp = celsius.toString()
        }

        imageUrl = iconUrl
    }

    fun Double.format(digits: Int) = "%.${digits}f".format(this)
}
