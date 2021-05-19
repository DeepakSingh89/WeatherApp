package com.example.weatherapp.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit= null;
    public static Retrofit getClient(){
        if (retrofit == null){

            retrofit = new Retrofit.Builder()
                    .baseUrl("http://api.openweathermap.org/data/2.5/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
      //  http://api.openweathermap.org/data/2.5/weather?q=delhi&appid=4680499c1414df43414f7665ebd1eca2&units=metric
    }
}
