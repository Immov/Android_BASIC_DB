package com.example.basic_db;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView city, weather, temper, humid, wind;
    EditText in_city, in_weather, in_temper, in_humid, in_wind;
    Button show, insert;

    DBHandler dbHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        city = (TextView) findViewById(R.id.txt_city);
        weather = (TextView) findViewById(R.id.txt_weather);
        temper = (TextView) findViewById(R.id.txt_temper);
        humid = (TextView) findViewById(R.id.txt_humid);
        wind = (TextView) findViewById(R.id.txt_wind);

        in_city = (EditText) findViewById(R.id.input_city);
        in_weather = (EditText) findViewById(R.id.input_weather);
        in_temper = (EditText) findViewById(R.id.input_temp);
        in_humid = (EditText) findViewById(R.id.input_humid);
        in_wind = (EditText) findViewById(R.id.input_wind);

        show = (Button) findViewById(R.id.btn_show);
        insert = (Button) findViewById(R.id.btn_insert);

        dbHandler = new DBHandler(MainActivity.this);
        dbHandler.addNewWeather(1, "Bandung", "Clear", "30*C", "50%", "1.5m/s South");// jaga jaga if empty
        dbHandler.updateWeather(1, "Bandung", "Clear", "30*C", "50%", "1.5m/s South");

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cityn = in_city.getText().toString();
                String weathern = in_weather.getText().toString();
                String tempern = in_temper.getText().toString();
                String humidn = in_humid.getText().toString();
                String windn = in_wind.getText().toString();
                dbHandler.updateWeather(1, cityn, weathern, tempern, humidn, windn);

                System.out.println(cityn);
                System.out.println(weathern);
                System.out.println(tempern);
                System.out.println(humidn);
                System.out.println(windn);
//                city.setText(cityn);
//                weather.setText(weathern);
//                temper.setText(tempern);
//                humid.setText(humidn);
//                wind.setText(windn);
            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                WeatherModal temp = new WeatherModal(1, "Bandung", "Clear", "30*C", "50%", "1.5m/s South");//Default
                WeatherModal temp = dbHandler.readWeathers(1);

                city.setText(temp.getCity());
                weather.setText(temp.getWeather());
                temper.setText(temp.getTemper());
                humid.setText(temp.getTemper());
                wind.setText(temp.getWind());
            }
        });

    }
}