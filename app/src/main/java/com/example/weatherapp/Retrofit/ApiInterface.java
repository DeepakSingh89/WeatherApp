package com.example.weatherapp.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("weather?&appid=4680499c1414df43414f7665ebd1eca2&units=metric")
    Call<Example> getWeatherData(@Query("q") String name);

}
