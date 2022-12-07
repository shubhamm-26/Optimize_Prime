package com.example.placementcellapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.animation.content.Content;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<MyViewHolder> {
    private final Context context;
    private List<DataClass> dataList;

    public void setSearchList(List<DataClass> dataSearchList){
        this.dataList = dataSearchList;
        notifyDataSetChanged();
    }

    public Adapter(Context context,List<DataClass> dataList){
        this.context = context;
        this.dataList = dataList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.company_list,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.recImage.setImageResource(dataList.get(position).getDataImage());
        holder.recTitle.setText(dataList.get(position).getDataTitle());
        holder.recDesc.setText(dataList.get(position).getDataDesc());
        holder.recPost.setText(dataList.get(position).getDataPost());

        holder.recCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intent = new Intent(context, Details.class);
                Intent.putExtra("Image",dataList.get(holder.getAdapterPosition()).getDataImage());
                Intent.putExtra("Title",dataList.get(holder.getAdapterPosition()).getDataTitle());
                Intent.putExtra("about",dataList.get(holder.getAdapterPosition()).getDataDesc());
                context.startActivity(Intent);
            }
        });
        
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder{

    ImageView recImage;
    TextView recTitle, recDesc, recPost;
    CardView recCard;


    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        recImage = itemView.findViewById(R.id.img1);
        recTitle = itemView.findViewById(R.id.comp_name);
        recDesc = itemView.findViewById(R.id.po);
        recPost = itemView.findViewById(R.id.post);
        recCard = itemView.findViewById(R.id.Companies);
    }
}