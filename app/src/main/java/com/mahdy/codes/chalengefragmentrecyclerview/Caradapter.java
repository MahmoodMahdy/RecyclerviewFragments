package com.mahdy.codes.chalengefragmentrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Caradapter extends RecyclerView.Adapter<Caradapter.ViewHolder> {
    ArrayList<Car> cars;
    ItemClecked activity ;
    public interface ItemClecked{
        void onItemClecked(int position) ;
    } ;

    public Caradapter(Context context , ArrayList<Car> list) {
        cars = list ;
        activity =(ItemClecked) context ;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row,parent,false) ;

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.itemView.setTag(cars.get(position));
        holder.tvModel.setText(cars.get(position).getModel());
        holder.tvOwner.setText(cars.get(position).getOwnerName());

        if(cars.get(position).getMake().equals("Mercedes")){
            holder.ivMake.setImageResource(R.drawable.mercedes);
        }else if (cars.get(position).getMake().equals("Volksvegen")){
            holder.ivMake.setImageResource(R.drawable.volkswagen);
        }else {
            holder.ivMake.setImageResource(R.drawable.nissan);
        }

    }

    @Override
    public int getItemCount() {
        return cars.size() ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivMake ;
        TextView tvModel , tvOwner ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivMake = itemView.findViewById(R.id.ivMake) ;
            tvModel = itemView.findViewById(R.id.tvModel) ;
            tvOwner = itemView.findViewById(R.id.tvOwner) ;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    activity.onItemClecked(cars.indexOf((Car) v.getTag()));

                }
            });
        }
    }
}
