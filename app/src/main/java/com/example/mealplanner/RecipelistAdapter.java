package com.example.mealplanner;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecipelistAdapter extends RecyclerView.Adapter<RecipelistAdapter.RecipelistViewHolder> {

    Context context;

    ArrayList<Details> recipelistdetails=new ArrayList<>();
    Boolean isSelected=false;
    ArrayList<Details> selectedItems=new ArrayList<>();

    public RecipelistAdapter(Context c,ArrayList<Details> recipelistdetails){
        context=c;
        this.recipelistdetails=recipelistdetails;
    }

    @Override
    public RecipelistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.recipelist_row,parent,false);
        return new RecipelistViewHolder(view,context);
    }

    @Override
    public void onBindViewHolder(final RecipelistAdapter.RecipelistViewHolder holder, final int position) {

        //holder.imageforrecipe.setImageResource(recipelistdetails.get(position).getImage());
        Picasso.get().load(recipelistdetails.get(position).getImage())
                .fit()
                .into(holder.imageforrecipe);
        holder.nameforrecipe.setText(recipelistdetails.get(position).getName());
        holder.rrating.setText(recipelistdetails.get(position).getRatting());

    }

    @Override
    public int getItemCount() {
        return recipelistdetails.size();
    }

    public class RecipelistViewHolder extends RecyclerView.ViewHolder {

        ImageView imageforrecipe;
        TextView nameforrecipe;
        TextView rrating;
        CardView cardviewforrecipe;

        public RecipelistViewHolder(final View itemView, Context context) {
            super(itemView);
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    isSelected=true;
                    if (selectedItems.contains(recipelistdetails.get(getAdapterPosition())))
                    {
                        cardviewforrecipe.setCardBackgroundColor(Color.WHITE);
                        selectedItems.remove(recipelistdetails.get(getAdapterPosition()));
                    }
                    else {
                        cardviewforrecipe.setCardBackgroundColor(Color.rgb(51,181,230));
                        selectedItems.add(recipelistdetails.get(getAdapterPosition()));
                    }
                    if (selectedItems.size()==0)
                    {
                        isSelected=false;
                    }
                    return true;
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isSelected)
                    {
                        if (selectedItems.contains(recipelistdetails.get(getAdapterPosition())))
                        {
                            //itemView.setBackgroundColor(Color.TRANSPARENT);
                            cardviewforrecipe.setCardBackgroundColor(Color.WHITE);
                            selectedItems.remove(recipelistdetails.get(getAdapterPosition()));
                        }
                        else {
                            cardviewforrecipe.setCardBackgroundColor(Color.rgb(51,181,230));
                            selectedItems.add(recipelistdetails.get(getAdapterPosition()));
                        }
                        if (selectedItems.size()==0)
                        {
                            isSelected=false;
                        }
                    }
                    else{

                    }
                }
            });

            imageforrecipe = (ImageView) itemView.findViewById(R.id.r_image);
            nameforrecipe = (TextView) itemView.findViewById(R.id.r_name);
            rrating = (TextView) itemView.findViewById(R.id.r_rate);
            cardviewforrecipe=(CardView)itemView.findViewById(R.id.cardviewofrecipe);

        }
    }
}
