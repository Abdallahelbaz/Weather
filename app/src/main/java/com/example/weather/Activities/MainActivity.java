package com.example.weather.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.weather.Adapters.HourlyAdapter;
import com.example.weather.Domains.Hourly;
import com.example.weather.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    HourlyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        addToRecyclerView();
        actions();
    }

    private void actions() {
        binding.nextdaysTV.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, FutureActivity.class)));
    }


    public void addToRecyclerView() {
        ArrayList<Hourly> hourlies = new ArrayList<>();
        hourlies.add(new Hourly("9:00 AM", 20, "cloudy"));
        hourlies.add(new Hourly("10:00 AM", 20, "sunny"));
        hourlies.add(new Hourly("11:00 AM", 20, "cloudy"));
        hourlies.add(new Hourly("12:00 PM", 20, "sunny"));
        hourlies.add(new Hourly("1:00 PM", 20, "sunny"));
        adapter = new HourlyAdapter(hourlies);
        binding.RVNext.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.RVNext.setAdapter(adapter);
    }
}