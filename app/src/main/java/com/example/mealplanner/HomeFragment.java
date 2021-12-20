package com.example.mealplanner;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.GridView;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    int[] recipeimg={R.drawable.breakfast,R.drawable.gfree,R.drawable.soup,R.drawable.coffee,R.drawable.cake,R.drawable.pastri,R.drawable.vegetables,R.drawable.steak};
    String[] recipename={"Sweet corn Soup","Tomato soup","Hot & Sour Soup","Mix Veg. Soup","Manchow soup","Oats","Pancake","Megggi"};
    String[] reciperating={"★★★★★","★★★","★★★★","★★★","★★★★★","★★★","★★★★","★★★"};
    String[] recipecal={"150","250","100","125","175","230","330","260"};
    String[] recipeduration={"10 min","20 min","30 min","40 min","50 min","45 min","25 min","15 min"};

    int[] categoryitemimg = {R.drawable.breakfast, R.drawable.gfree, R.drawable.soup, R.drawable.coffee, R.drawable.cake, R.drawable.pastri, R.drawable.vegetables, R.drawable.steak};

    ArrayList<Details> details;

    public HomeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

//        TextView nametitle=view.findViewById(R.id.nametitile);

        GridView gridforcat=view.findViewById(R.id.gridforcat);
        RecyclerView mostratedrecycle=view.findViewById(R.id.mostratedrecycle);

        details=new ArrayList<>();
        for (int i=0;i<recipename.length;i++)
        {
            Details detailsofrecipies=new Details(recipeimg[i],recipename[i],reciperating[i],recipecal[i],recipeduration[i]);
            details.add(detailsofrecipies);
        }

        CategoryAdapter categoryAdapter=new CategoryAdapter(HomeFragment.this,categoryitemimg);
        Listadapeter listadapeter=new Listadapeter(getContext(),details);

        gridforcat.setAdapter(categoryAdapter);
        mostratedrecycle.setAdapter(listadapeter);
        mostratedrecycle.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

        return view;
    }
}