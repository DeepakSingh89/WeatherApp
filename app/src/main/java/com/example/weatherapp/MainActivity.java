package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weatherapp.Retrofit.ApiClient;
import com.example.weatherapp.Retrofit.ApiInterface;
import com.example.weatherapp.Retrofit.Example;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    String City;
    ImageView search;
    EditText city_edittext;
    TextView city;
    TextView country;
    TextView temp;
    TextView feels;
    TextView humidity;
    TextView min_temp;
    TextView max_temp;
    TextView sunrises;
    TextView sunsets;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search=(ImageView) findViewById(R.id.search);
        city_edittext= (EditText) findViewById(R.id.city_edittext);
        city= (TextView) findViewById(R.id.city);
        country= (TextView)findViewById(R.id.country);
        temp= (TextView)findViewById(R.id.temp);
        humidity= (TextView)findViewById(R.id.humidity);
        min_temp= (TextView)findViewById(R.id.min_temp);
        max_temp= (TextView)findViewById(R.id.max_temp);
        sunrises= (TextView) findViewById(R.id.sunrises);
        sunsets= (TextView)findViewById(R.id.sunsets);
        feels= (TextView)findViewById(R.id.feels);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                City = city.getText().toString();
                getWeatherData(city_edittext.getText().toString().trim());

            }
        });

    }

    private void getWeatherData(String name) {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Example> call = apiInterface.getWeatherData(name);

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                temp.setText("Temperature "+" " +response.body().getMain().getTemp()+ "°C");
                humidity.setText("Humidity "+" " +response.body().getMain().getHumidity()+ "°C");
                feels.setText("Feels like "+" " +response.body().getMain().getFeels_like()+ "°C" );
                min_temp.setText(response.body().getMain().getTemp_min()+ "°C");
                max_temp.setText(response.body().getMain().getTemp_max()+ "°C");

                sunrises.setText(response.body().getSys().getSunrise());
                sunsets.setText(response.body().getSys().getSunset());

            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"City not found" , Toast.LENGTH_LONG).show();
            }
        });
    }


}