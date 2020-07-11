package com.example.covid19api;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CovidAdapter extends RecyclerView.Adapter<CovidAdapter.MyViewHolder> {
    Context Myct;
    List<Covid> myList;
    public CovidAdapter(Context ct, List<Covid> covidList) {
            Myct=ct;
            myList = covidList;
        }


    @NonNull
    @Override
    public CovidAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(Myct).inflate(R.layout.item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CovidAdapter.MyViewHolder holder, int position) {
        Covid c = myList.get(position);
        holder.tv_act.setText(c.getActive());
        holder.tv_rec.setText(c.getRecovered());
        holder.tv_det.setText(c.getDeaths());
        holder.tv_date.setText(c.getDate());
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_act,tv_rec,tv_det,tv_date;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_act=itemView.findViewById(R.id.active);
            tv_rec=itemView.findViewById(R.id.recovered);
            tv_det=itemView.findViewById(R.id.death);
            tv_date=itemView.findViewById(R.id.date);
        }
    }
}
