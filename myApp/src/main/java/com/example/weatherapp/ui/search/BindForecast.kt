package com.example.weatherapp.ui.search

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import com.example.weatherapp.data.responseById.Forecast
import kotlin.properties.Delegates

class BindForecast(val forecastList: List<Forecast>) : BaseObservable() {





    @get:Bindable
    var imageUrlForecast by Delegates.observable("http://openweathermap.org/img/wn/10d@2x.png") { _, _, _ ->
        notifyPropertyChanged(
            BR.imageUrlForecast
        )
    }

    @get:Bindable
    var time by Delegates.observable("http://openweathermap.org/img/wn/10d@2x.png") { _, _, _ ->
        notifyPropertyChanged(
            BR.time
        )
    }



    init {


        forecastList.map{
           val icon= it.weather[0].icon
            imageUrlForecast = "http://openweathermap.org/img/w/${icon}.png"
        }


        forecastList.map {
          time =  it.dtTxt
        }
    }
}
