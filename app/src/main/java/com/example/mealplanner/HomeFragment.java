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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    int[] recipeimg={R.drawable.breakfast,R.drawable.gfree,R.drawable.soup,R.drawable.coffee,R.drawable.cake,R.drawable.pastri,R.drawable.vegetables,R.drawable.steak};
    String[] recipename={"Sweet corn Soup","Tomato soup","Hot & Sour Soup","Mix Veg. Soup","Manchow soup","Oats","Pancake","Megggi"};
    String[] reciperating={"★★★★★","★★★","★★★★","★★★","★★★★★","★★★","★★★★","★★★"};

    int[] categoryitemimg = {R.drawable.breakfast, R.drawable.gfree, R.drawable.soup, R.drawable.coffee, R.drawable.cake, R.drawable.pastri, R.drawable.vegetables, R.drawable.steak};

    ArrayList<Details> details;

    public HomeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        TextView nametitle=view.findViewById(R.id.nametitile);

        GridView gridforcat=view.findViewById(R.id.gridforcat);
        RecyclerView mostratedrecycle=view.findViewById(R.id.mostratedrecycle);

        details=new ArrayList<>();
        for (int i=0;i<recipename.length;i++)
        {
            Details detailsofrecipies=new Details(recipeimg[i],recipename[i],reciperating[i]);
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