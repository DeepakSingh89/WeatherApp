package com.example.weatherapp.Retrofit;

import com.google.gson.annotations.SerializedName;


public class Sys {
    @SerializedName("sunrise")
    String sunrise;

    @SerializedName("sunset")
    String sunset;

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }
}
