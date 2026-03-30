package com.duy.thoitiet;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {

    private List<WeatherModel> weatherList;

    public WeatherAdapter(List<WeatherModel> weatherList) {
        this.weatherList = weatherList;
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_weather, parent, false);
        return new WeatherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder holder, int position) {
        WeatherModel weather = weatherList.get(position);
        holder.tvCityName.setText(weather.getCityName());
        holder.tvDescription.setText(weather.getDescription());
        holder.tvTemp.setText(weather.getTemp() + "°C");
    }

    @Override
    public int getItemCount() {
        return weatherList.size();
    }

    public static class WeatherViewHolder extends RecyclerView.ViewHolder {
        TextView tvCityName, tvDescription, tvTemp;

        public WeatherViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCityName = itemView.findViewById(R.id.tvCityNameItem);
            tvDescription = itemView.findViewById(R.id.tvDescriptionItem);
            tvTemp = itemView.findViewById(R.id.tvTempItem);
        }
    }
}
