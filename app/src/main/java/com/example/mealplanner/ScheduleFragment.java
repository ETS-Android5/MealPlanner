package com.example.mealplanner;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.time.LocalDate;
import java.util.ArrayList;

import static com.example.mealplanner.CalendarUtils.daysInWeekArray;
import static com.example.mealplanner.CalendarUtils.monthYearFromDate;


public class ScheduleFragment extends Fragment implements CalendarAdapter.OnItemListener{

    int[] bldimages={R.drawable.breakfastfinal,R.drawable.lunchimage,R.drawable.dinnerimage};

    private TextView monthYearText;
    private RecyclerView calendarRecyclerView;
    private RecyclerView bldrecycler;

    public ScheduleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview= inflater.inflate(R.layout.fragment_schedule, container, false);

        calendarRecyclerView = rootview.findViewById(R.id.calendarRecyclerView);
        monthYearText = rootview.findViewById(R.id.monthYearTV);
        bldrecycler=rootview.findViewById(R.id.bldrecycler);

        ScheduleAdapter scheduleAdapter=new ScheduleAdapter(getContext(),bldimages);
        bldrecycler.setAdapter(scheduleAdapter);
        bldrecycler.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        CalendarUtils.selectedDate = LocalDate.now();
        setWeekView();

        return rootview;
    }

    private void setWeekView()
    {
        monthYearText.setText(monthYearFromDate(CalendarUtils.selectedDate));
        ArrayList<LocalDate> days = daysInWeekArray(CalendarUtils.selectedDate);

        CalendarAdapter calendarAdapter = new CalendarAdapter(days, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 7);
        calendarRecyclerView.setLayoutManager(layoutManager);
        calendarRecyclerView.setAdapter(calendarAdapter);
        //    setEventAdpater();
    }

    @Override
    public void onItemClick(int position, LocalDate date)
    {
        CalendarUtils.selectedDate = date;
        setWeekView();
    }

}