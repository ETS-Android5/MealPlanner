package com.example.mealplanner;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.example.mealplanner.CalendarUtils.daysInWeekArray;
import static com.example.mealplanner.CalendarUtils.monthYearFromDate;


public class ScheduleFragment extends Fragment implements CalendarAdapter.OnItemListener{


    private TextView monthYearText;
    private RecyclerView calendarRecyclerView;

    RelativeLayout breakfast_txt,lunch_txt,dinner_txt;
    RecyclerView breakfast_rv,lunch_rv,dinner_rv;
    ArrayList<ScheduleDetails> breakfastschedule;

    int[] bimages={R.drawable.healthysandwich,R.drawable.mexicanbeansoup};
    String[] bnames={"Grilled Mashroom melt","Mexican bean soup with guacamole"};
    String[] brating={"★★★★★","★★★"};
    String[] bduration={"25 mins","30 mins"};
    String[] bcal={"270","150"};
    String[] btime={"09:00 am","09:25 am"};

    int[] limages={R.drawable.mexicanbeansoup};
    String[] lnames={"Mexican bean soup with guacamole"};
    String[] lrating={"★★★"};
    String[] lcal={"150"};
    String[] lduration={"30 mins"};
    String[] ltime={"12:00 pm"};

    int[] dimages={R.drawable.butternutsquashmaccheese};
    String[] dnames={"Butternut squash mac and cheese"};
    String[] drating={"★★★"};
    String[] dcal={"250"};
    String[] dduration={"45 mins"};
    String[] dtime={"Schedule"};

    public ScheduleFragment() {
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootview= inflater.inflate(R.layout.fragment_schedule, container, false);

        breakfastschedule=new ArrayList<>();

        for (int i=0;i< bnames.length;i++)
        {
            ScheduleDetails detailschedule=new ScheduleDetails(bimages[i],bnames[i],brating[i],bcal[i],bduration[i],btime[i]);
            breakfastschedule.add(detailschedule);
        }

        calendarRecyclerView = rootview.findViewById(R.id.calendarRecyclerView);
        monthYearText = rootview.findViewById(R.id.monthYearTV);

        breakfast_txt=rootview.findViewById(R.id.breakfast_txt);
        lunch_txt=rootview.findViewById(R.id.lunch_txt);
        dinner_txt=rootview.findViewById(R.id.dinner_txt);

        breakfast_rv=rootview.findViewById(R.id.breakfast_rv);
        lunch_rv=rootview.findViewById(R.id.lunch_rv);
        dinner_rv=rootview.findViewById(R.id.dinner_rv);

        BreakfastAdapter breakfastAdapter=new BreakfastAdapter(getContext(),breakfastschedule);
        breakfast_rv.setAdapter(breakfastAdapter);
        breakfast_rv.setLayoutManager(new GridLayoutManager(getContext(),1,GridLayoutManager.VERTICAL,false));

        breakfast_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextpageintent=new Intent(getContext(),RecipeList.class);
                nextpageintent.putExtra("name","Select Recipes for Breakfast");
                startActivity(nextpageintent);
            }
        });

        lunch_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextpageintent=new Intent(getContext(),RecipeList.class);
                nextpageintent.putExtra("name","Select Recipes for Lunch");
                startActivity(nextpageintent);
            }
        });

        dinner_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextpageintent=new Intent(getContext(),RecipeList.class);
                nextpageintent.putExtra("name","Select Recipes for Dinner");
                startActivity(nextpageintent);
            }
        });

        CalendarUtils.selectedDate = LocalDate.now();
        setWeekView();

            return rootview;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void setWeekView()
    {
        monthYearText.setText(monthYearFromDate(CalendarUtils.selectedDate));
        ArrayList<LocalDate> days = daysInWeekArray(CalendarUtils.selectedDate);

        CalendarAdapter calendarAdapter = new CalendarAdapter(days, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 7);
        calendarRecyclerView.setLayoutManager(layoutManager);
        calendarRecyclerView.setAdapter(calendarAdapter);
        //  setEventAdpater();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onItemClick(int position, LocalDate date)
    {
        CalendarUtils.selectedDate = date;
        setWeekView();
    }

}