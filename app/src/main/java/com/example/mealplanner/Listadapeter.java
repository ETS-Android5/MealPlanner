package com.example.mealplanner;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Listadapeter extends RecyclerView.Adapter<Listadapeter.ListviewHolder> {

    Context context;

    ArrayList<Details> recipelistdetails=new ArrayList<>();

    public Listadapeter(Context c, ArrayList<Details> recipelistdetails) {
        context = c;
        this.recipelistdetails=recipelistdetails;

    }
    
    @Override
    public ListviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recipelist_row, parent, false);
        return new ListviewHolder(view);
    }

    @Override
    public void onBindViewHolder(Listadapeter.ListviewHolder holder, int position) {

        holder.imageforrecipe.setImageResource(recipelistdetails.get(position).getImage());
        holder.nameforrecipe.setText(recipelistdetails.get(position).getName());
        holder.rrating.setText(recipelistdetails.get(position).getRatting());

    }

    @Override
    public int getItemCount() {
        return recipelistdetails.size();
    }

    public class ListviewHolder extends RecyclerView.ViewHolder {

        ImageView imageforrecipe;
        TextView nameforrecipe;
        TextView rrating;

        public ListviewHolder(final View itemView) {
            super(itemView);
            imageforrecipe = (ImageView) itemView.findViewById(R.id.r_image);
            nameforrecipe = (TextView) itemView.findViewById(R.id.r_name);
            rrating = (TextView) itemView.findViewById(R.id.r_rate);
        }
    }
}