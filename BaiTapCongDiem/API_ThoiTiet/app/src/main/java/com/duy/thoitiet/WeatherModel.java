package com.duy.thoitiet;

public class WeatherModel {
    private String cityName;
    private String temp;
    private String description;

    public WeatherModel(String cityName, String temp, String description) {
        this.cityName = cityName;
        this.temp = temp;
        this.description = description;
    }

    public String getCityName() {
        return cityName;
    }

    public String getTemp() {
        return temp;
    }

    public String getDescription() {
        return description;
    }
}
