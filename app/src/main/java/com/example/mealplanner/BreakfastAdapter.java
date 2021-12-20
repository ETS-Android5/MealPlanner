package com.example.mealplanner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BreakfastAdapter extends RecyclerView.Adapter<BreakfastAdapter.BreakfastviewHolder> {

    Context context;
    ArrayList<ScheduleDetails> breakfastschedule=new ArrayList<>();;

    public BreakfastAdapter(Context c,ArrayList<ScheduleDetails> scheduleDetails)
    {
        context=c;
        this.breakfastschedule=scheduleDetails;
    }

    @NonNull
    @Override
    public BreakfastviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.foodplanner, parent, false);
        return new BreakfastviewHolder(view);
    }

    @Override
    public void onBindViewHolder(BreakfastviewHolder holder, int position) {
       Picasso.get().load(breakfastschedule.get(position).getImage())
               .fit()
               .into(holder.imageofr);
       holder.nameofr.setText(breakfastschedule.get(position).getName());
       holder.calofr.setText(breakfastschedule.get(position).getCalories());
       holder.rattingofr.setText(breakfastschedule.get(position).getRatting());
       holder.preptime.setText(breakfastschedule.get(position).getDuration());
       holder.timeofr.setText(breakfastschedule.get(position).getSchedule_time());
    }

    @Override
    public int getItemCount() {
        return breakfastschedule.size();
    }

    public class BreakfastviewHolder extends RecyclerView.ViewHolder {

        ImageView imageofr;
        TextView nameofr,calofr,timeofr,rattingofr,preptime;

        public BreakfastviewHolder(View itemView) {
            super(itemView);
            imageofr=itemView.findViewById(R.id.imageofr);
            nameofr=itemView.findViewById(R.id.nameofr);
            calofr=itemView.findViewById(R.id.caloriesofr);
            rattingofr=itemView.findViewById(R.id.rattingofr);
            preptime=itemView.findViewById(R.id.preptime);
            timeofr=itemView.findViewById(R.id.timeofr);
        }
    }
}