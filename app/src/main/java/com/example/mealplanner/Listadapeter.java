package com.example.mealplanner;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Listadapeter extends RecyclerView.Adapter<Listadapeter.ListviewHolder> {

    Context context;

    ArrayList<Details> recipelistdetails;

    public Listadapeter(Context c, ArrayList<Details> recipelistdetails) {
        context = c;
        this.recipelistdetails=recipelistdetails;
    }

    @NonNull
    @Override
    public ListviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.homerecipe_row, parent, false);
        return new ListviewHolder(view);
    }

    @Override
    public void onBindViewHolder(Listadapeter.ListviewHolder holder, final int position) {

        holder.imageforrecipe.setImageResource(recipelistdetails.get(position).getImage());
        holder.nameforrecipe.setText(recipelistdetails.get(position).getName());
        holder.rrating.setText(recipelistdetails.get(position).getRatting());
        holder.rcal.setText(recipelistdetails.get(position).getCalories());
        holder.rduration.setText(recipelistdetails.get(position).getDuration());

        holder.cardlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent recipedetailintent=new Intent(context,RecipeInDetail.class);
                recipedetailintent.putExtra("recipeimage",recipelistdetails.get(position).getImage());
                recipedetailintent.putExtra("recipename",recipelistdetails.get(position).getName());
                recipedetailintent.putExtra("reccal",recipelistdetails.get(position).getCalories());
                recipedetailintent.putExtra("recratting",recipelistdetails.get(position).getRatting());
                recipedetailintent.putExtra("recipeduration",recipelistdetails.get(position).getDuration());
                context.startActivity(recipedetailintent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return recipelistdetails.size();
    }

    public static class ListviewHolder extends RecyclerView.ViewHolder {

        ImageView imageforrecipe;
        TextView nameforrecipe;
        TextView rrating,rcal,rduration;
        CardView cardlayout;

        public ListviewHolder(final View itemView) {
            super(itemView);
            imageforrecipe = itemView.findViewById(R.id.r_img);
            nameforrecipe = itemView.findViewById(R.id.r_name);
            rrating = itemView.findViewById(R.id.r_ratting);
            rcal=itemView.findViewById(R.id.r_cal);
            rduration=itemView.findViewById(R.id.r_duration);
            cardlayout=itemView.findViewById(R.id.cardlayout);


        }
    }
}