package com.example.mealplanner;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder> {

    Context context;
    final int[] myimage;
    ArrayList<String> recipename=new ArrayList<>();

    public ScheduleAdapter(Context c,int[] myimage) {
        context=c;
        this.myimage = myimage;
    }

    @NonNull
    @Override
    public ScheduleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.bld_row_design,parent,false);
        return new ScheduleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ScheduleAdapter.ScheduleViewHolder holder, final int position) {

        Picasso.get().load(myimage[position])
                .fit()
                .into(holder.mybldimage);

        holder.addrecipetext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position==0){
                    Intent addrecipeintent=new Intent(context,RecipeList.class);
                    addrecipeintent.putExtra("bldvalue","Select Recipes for Breakfast");
                    context.startActivity(addrecipeintent);

                }
                else if(position==1){
                    Intent addrecipeintent=new Intent(context,RecipeList.class);
                    addrecipeintent.putExtra("bldvalue","Select Recipes for Lunch");
                    context.startActivity(addrecipeintent);

                }
                else{
                    Intent addrecipeintent=new Intent(context,RecipeList.class);
                    addrecipeintent.putExtra("bldvalue","Select Recipes for Dinner");
                    context.startActivity(addrecipeintent);

                }
            }
        });

        holder.addrecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.invisiblecard.setVisibility(View.VISIBLE);
                holder.addicon.setImageResource(R.drawable.ic_baseline_remove_circle_24);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myimage.length;
    }

    public static class ScheduleViewHolder extends RecyclerView.ViewHolder {

        ImageView mybldimage;
        CardView addrecipe;
        CardView invisiblecard;
        TextView addrecipetext;
        ImageView addicon;
        ListView listofrecipies;

        public ScheduleViewHolder(View itemView) {

            super(itemView);
            listofrecipies=itemView.findViewById(R.id.recipelistrecycle);
            mybldimage=itemView.findViewById(R.id.imagesforbld);
            addrecipe=itemView.findViewById(R.id.addrecipe);
            invisiblecard=itemView.findViewById(R.id.invisiblecard);
            addrecipetext=itemView.findViewById(R.id.addrecipetext);
            addicon=itemView.findViewById(R.id.addicon);

        }
    }
}
