package com.example.foofator.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
//import com.example.foofator.Activity.Domain.FoodDomain;
import com.example.foofator.Activity.ShowDetailActivity;
import com.example.foofator.Domain.FoodDomain;
import com.example.foofator.R;

import java.util.ArrayList;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {
    ArrayList<FoodDomain> popluarFood;

    public PopularAdapter(ArrayList<FoodDomain> popularFood) {
        this.popluarFood = popularFood;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_popular,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularAdapter.ViewHolder holder, int position) {
    holder.title.setText(popluarFood.get(position).getTitle());
    holder.fee.setText(String.valueOf(popluarFood.get(position).getFee()));

    int drawableResourceId=holder.itemView.getContext().getResources().getIdentifier(popluarFood.get(position).getPic(),"drawable",holder.itemView.getContext().getPackageName());
    Glide.with(holder.itemView.getContext())
            .load(drawableResourceId)
            .into(holder.pic);

    holder.addBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent=new Intent(holder.itemView.getContext(), ShowDetailActivity.class);
            intent.putExtra("object", popluarFood.get(position));
            holder.itemView.getContext().startActivity(intent);

        }
    });
    }

    @Override
    public int getItemCount() {
        return popluarFood.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title,fee;
        ImageView pic;
        TextView addBtn;
        ConstraintLayout mainLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            fee=itemView.findViewById(R.id.fee);
            pic=itemView.findViewById(R.id.pic);
            addBtn=itemView.findViewById(R.id.addBtn);

        }
    }
}
