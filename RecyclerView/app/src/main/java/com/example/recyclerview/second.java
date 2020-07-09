package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class second extends RecyclerView.Adapter<second.myViewHolder>{
    int img[];
    String cod[],ver[],myApi[],rel[];
    Context ct;
    public second(MainActivity mainActivity, int[] images, String[] codeName, String[] version, String[] api, String[] release) {
        img=images;
        cod=codeName;
        ver=version;
        myApi=api;
        rel=release;
        ct=mainActivity;
    }

    @NonNull
    @Override
    public second.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ct).inflate(R.layout.item,parent,false);
        myViewHolder viewHolder=new myViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull second.myViewHolder holder, int position) {
        holder.iv.setImageResource(img[position]);
        holder.t1.setText(cod[position]);
        holder.t2.setText(ver[position]);
        holder.t3.setText(myApi[position]);
        holder.t4.setText(rel[position]);
    }

    @Override
    public int getItemCount() {
        return img.length;
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView t1,t2,t3,t4;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.image);
            t1=itemView.findViewById(R.id.code);
            t2=itemView.findViewById(R.id.version);
            t3=itemView.findViewById(R.id.level);
            t4=itemView.findViewById(R.id.date);
        }
    }
}
