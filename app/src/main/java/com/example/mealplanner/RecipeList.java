package com.example.mealplanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class RecipeList extends AppCompatActivity implements RecipeListListener{

    int[] recipeimg={R.drawable.breakfast,R.drawable.gfree,R.drawable.soup,R.drawable.coffee,R.drawable.cake,R.drawable.pastri,R.drawable.vegetables,R.drawable.steak};
    String[] recipename={"Sweet corn Soup","Tomato soup","Hot & Sour Soup","Mix Veg. Soup","Manchow soup","Oats","Pancake","Megggi"};
    String[] reciperating={"★★★★★","★★★","★★★★","★★★","★★★★★","★★★","★★★★","★★★"};
    String[] recipecal={"150","250","100","125","175","230","330","260"};
    String[] recipeduration={"10 min","20 min","30 min","40 min","50 min","45 min","25 min","15 min"};

    RelativeLayout addrecipe;
    ArrayList<Details> details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);

        TextView titleforlist;
        titleforlist=findViewById(R.id.titleforlist);
        titleforlist.setText(getIntent().getStringExtra("name"));

        details=new ArrayList<>();

        for (int i=0;i<recipename.length;i++)
        {
            Details detailsofrecipies=new Details(recipeimg[i],recipename[i],reciperating[i],recipecal[i],recipeduration[i]);
            details.add(detailsofrecipies);
        }



        RecyclerView reclyclerviewrecipe=findViewById(R.id.reclyclerviewrecipe);

        RecipelistAdapter recipelistAdapter=new RecipelistAdapter(RecipeList.this,details);
        reclyclerviewrecipe.setAdapter(recipelistAdapter);
        reclyclerviewrecipe.setLayoutManager(new GridLayoutManager(RecipeList.this,1,GridLayoutManager.VERTICAL,false));

    }

    @Override
    public void onRecipeListAction(Boolean isselected) {

    }
}