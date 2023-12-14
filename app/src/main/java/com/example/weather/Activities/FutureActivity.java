package com.example.weather.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.weather.Adapters.FutureAdapter;
import com.example.weather.Domains.FutureDomain;
import com.example.weather.databinding.ActivityFutureBinding;

import java.util.ArrayList;

public class FutureActivity extends AppCompatActivity {

    private FutureAdapter adapter;
    ActivityFutureBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityFutureBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addToRecyclerView();
        setVariable();
    }

    private void setVariable() {
        binding.backBtn.setOnClickListener(view -> startActivity(new Intent(FutureActivity.this,MainActivity.class)));
    }

    private void addToRecyclerView(){
        ArrayList<FutureDomain> domains=new ArrayList<>();
        domains.add(new FutureDomain("Sat","cloudy","Cloudy",5,3));
        domains.add(new FutureDomain("Son","sunny","Sunny",7,4));
        domains.add(new FutureDomain("Mon","rain","Rain",8,4));
        domains.add(new FutureDomain("Tues","rainy","Rainy",10,7));
        domains.add(new FutureDomain("Wednes","storm","Storm",9,6));
        domains.add(new FutureDomain("Thures","wind","Wind",8,5));
        domains.add(new FutureDomain("Fri","windy","Windy",7,3));
        adapter=new FutureAdapter(domains);
        binding.RVfuture.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        binding.RVfuture.setAdapter(adapter);
    }

}