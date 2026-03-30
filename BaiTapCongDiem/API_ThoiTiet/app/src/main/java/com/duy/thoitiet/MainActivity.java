package com.duy.thoitiet;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvWeather;
    private WeatherAdapter adapter;
    private List<WeatherModel> weatherList;
    private ProgressBar progressBar;
    private Button btnRetry;
    
    private final String API_KEY = "bf861d369e0691512f462a7a5ea73142";

    private final String[] cities = {
            "Hanoi", "Ho Chi Minh", "Da Nang", "Hai Phong", 
            "Can Tho", "Nha Trang", "Hue", "Da Lat", "Vung Tau", "Nam Dinh"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvWeather = findViewById(R.id.rvWeather);
        progressBar = findViewById(R.id.progressBar);
        btnRetry = findViewById(R.id.btnRetry);

        weatherList = new ArrayList<>();
        adapter = new WeatherAdapter(weatherList);
        rvWeather.setLayoutManager(new LinearLayoutManager(this));
        rvWeather.setAdapter(adapter);

        btnRetry.setOnClickListener(v -> loadWeatherData());

        loadWeatherData();
    }

    private void loadWeatherData() {
        if (!isNetworkAvailable()) {
            Toast.makeText(this, "Vui lòng bật Wifi hoặc Dữ liệu di động!", Toast.LENGTH_LONG).show();
            btnRetry.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.GONE);
            return;
        }

        btnRetry.setVisibility(View.GONE);
        weatherList.clear();
        adapter.notifyDataSetChanged();
        
        new GetAllWeatherTask().execute();
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private class GetAllWeatherTask extends AsyncTask<Void, WeatherModel, Void> {
        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected Void doInBackground(Void... voids) {
            for (String cityName : cities) {
                try {
                    String encodedCity = URLEncoder.encode(cityName, "UTF-8");
                    String urlString = "https://api.openweathermap.org/data/2.5/weather?q=" + encodedCity + "&appid=" + API_KEY + "&units=metric&lang=vi";
                    
                    URL url = new URL(urlString);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(5000);
                    connection.setReadTimeout(5000);

                    if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                        StringBuilder result = new StringBuilder();
                        String line;
                        while ((line = reader.readLine()) != null) {
                            result.append(line);
                        }
                        reader.close();

                        JSONObject jsonObject = new JSONObject(result.toString());
                        String name = jsonObject.getString("name");
                        if (name.contains("Ha Noi") || name.contains("Hanoi")) name = "Hà Nội";
                        if (name.contains("Ho Chi Minh")) name = "TP. Hồ Chí Minh";

                        JSONObject main = jsonObject.getJSONObject("main");
                        String temp = String.format("%.1f", main.getDouble("temp"));
                        
                        String desc = "Nắng nhẹ";
                        JSONArray wa = jsonObject.getJSONArray("weather");
                        if (wa.length() > 0) desc = wa.getJSONObject(0).getString("description");

                        publishProgress(new WeatherModel(name, temp, desc));
                    }
                } catch (Exception e) {
                    Log.e("WeatherError", "Lỗi: " + e.getMessage());
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(WeatherModel... values) {
            weatherList.add(values[0]);
            adapter.notifyItemInserted(weatherList.size() - 1);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            progressBar.setVisibility(View.GONE);
            if (weatherList.isEmpty()) {
                btnRetry.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this, "Không tìm thấy dữ liệu. Hãy kiểm tra mạng!", Toast.LENGTH_LONG).show();
            }
        }
    }
}
