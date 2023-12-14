package com.example.weather.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.weather.Domains.Hourly;
import com.example.weather.R;

import java.util.ArrayList;

public class HourlyAdapter extends RecyclerView.Adapter<HourlyAdapter.ViewHolder> {

    ArrayList<Hourly> hourlies;
    Context context;

    public HourlyAdapter(ArrayList<Hourly> hourlies) {
        this.hourlies = hourlies;
    }


    @NonNull
    @Override
    public HourlyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hourviewholder, parent, false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HourlyAdapter.ViewHolder holder, int position) {
        holder.hourTV.setText(hourlies.get(position).getHour());
        holder.temTV.setText(hourlies.get(position).getTemp() + " °");
        int drawableResourceID = holder.itemView.getResources()
                .getIdentifier(hourlies.get(position).getPicPath(), "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(context)
                .load(drawableResourceID)
                .into(holder.pic);
    }

    @Override
    public int getItemCount() {
        return hourlies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView hourTV, temTV;
        ImageView pic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            hourTV = itemView.findViewById(R.id.hourTV);
            temTV = itemView.findViewById(R.id.tempTV);
            pic = itemView.findViewById(R.id.pic);
        }
    }

}
