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
import com.example.weather.Domains.FutureDomain;
import com.example.weather.R;

import java.util.ArrayList;

public class FutureAdapter extends RecyclerView.Adapter<FutureAdapter.ViewHolder> {

    ArrayList<FutureDomain> futures;
    Context context;

    public FutureAdapter(ArrayList<FutureDomain> futures) {
        this.futures = futures;
    }


    @NonNull
    @Override
    public FutureAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.futureviewholder, parent, false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FutureAdapter.ViewHolder holder, int position) {
        holder.dayTV.setText(futures.get(position).getDay());
        holder.statusTV.setText(futures.get(position).getStatus());
        holder.lowTV.setText(futures.get(position).getLowTemp()+"°");
        holder.highTV.setText(futures.get(position).getHighTemp()+"°");

        int drawableResourceID = holder.itemView.getResources()
                .getIdentifier(futures.get(position).getPicPath(), "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(context)
                .load(drawableResourceID)
                .into(holder.pic);
    }

    @Override
    public int getItemCount() {
        return futures.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView dayTV, statusTV,highTV,lowTV;
        ImageView pic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dayTV = itemView.findViewById(R.id.dayTV);
            statusTV = itemView.findViewById(R.id.statusTV);
            highTV = itemView.findViewById(R.id.highTV);
            lowTV = itemView.findViewById(R.id.lowTV);
            pic = itemView.findViewById(R.id.pic);
        }
    }

}
