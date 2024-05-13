package com.own_world.weatherapp_jetpack.Network
import com.google.gson.annotations.SerializedName


data class CurrentWeather(
    @SerializedName("base")
    val base: String?, // stations
    @SerializedName("clouds")
    val clouds: Clouds?,
    @SerializedName("cod")
    val cod: Int?, // 200
    @SerializedName("coord")
    val coord: Coord?,
    @SerializedName("dt")
    val dt: Int?, // 1715604831
    @SerializedName("id")
    val id: Int?, // 3163858
    @SerializedName("main")
    val main: Main?,
    @SerializedName("name")
    val name: String?, // Zocca
    @SerializedName("sys")
    val sys: Sys?,
    @SerializedName("timezone")
    val timezone: Int?, // 7200
    @SerializedName("visibility")
    val visibility: Int?, // 10000
    @SerializedName("weather")
    val weather: List<Weather?>?,
    @SerializedName("wind")
    val wind: Wind?
) {
    data class Clouds(
        @SerializedName("all")
        val all: Int? // 100
    )

    data class Coord(
        @SerializedName("lat")
        val lat: Double?, // 44.34
        @SerializedName("lon")
        val lon: Double? // 10.99
    )

    data class Main(
        @SerializedName("feels_like")
        val feelsLike: Double?, // 292.74
        @SerializedName("grnd_level")
        val grndLevel: Int?, // 930
        @SerializedName("humidity")
        val humidity: Int?, // 53
        @SerializedName("pressure")
        val pressure: Int?, // 1013
        @SerializedName("sea_level")
        val seaLevel: Int?, // 1013
        @SerializedName("temp")
        val temp: Double?, // 293.29
        @SerializedName("temp_max")
        val tempMax: Double?, // 294.86
        @SerializedName("temp_min")
        val tempMin: Double? // 291.42
    )

    data class Sys(
        @SerializedName("country")
        val country: String?, // IT
        @SerializedName("id")
        val id: Int?, // 2004688
        @SerializedName("sunrise")
        val sunrise: Int?, // 1715572259
        @SerializedName("sunset")
        val sunset: Int?, // 1715625235
        @SerializedName("type")
        val type: Int? // 2
    )

    data class Weather(
        @SerializedName("description")
        val description: String?, // overcast clouds
        @SerializedName("icon")
        val icon: String?, // 04d
        @SerializedName("id")
        val id: Int?, // 804
        @SerializedName("main")
        val main: String? // Clouds
    )

    data class Wind(
        @SerializedName("deg")
        val deg: Int?, // 95
        @SerializedName("gust")
        val gust: Double?, // 2.97
        @SerializedName("speed")
        val speed: Double? // 0.95
    )
}