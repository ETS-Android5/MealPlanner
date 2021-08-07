package com.example.mealplanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class RecipeList extends AppCompatActivity implements RecipeListListener{

    int[] recipeimg={R.drawable.breakfast,R.drawable.gfree,R.drawable.soup,R.drawable.coffee,R.drawable.cake,R.drawable.pastri,R.drawable.vegetables,R.drawable.steak};
    String[] recipename={"Sweet corn Soup","Tomato soup","Hot & Sour Soup","Mix Veg. Soup","Manchow soup","Oats","Pancake","Megggi"};
    String[] reciperating={"★★★★★","★★★","★★★★","★★★","★★★★★","★★★","★★★★","★★★"};

    ArrayList<Details> details;
    Button addbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);

        TextView titleforlist;
        titleforlist=(TextView)findViewById(R.id.titleforlist);
        titleforlist.setText(getIntent().getStringExtra("bldvalue"));

        addbtn=(Button)findViewById(R.id.addbtn);

        details=new ArrayList<>();
        for (int i=0;i<recipename.length;i++)
        {
            Details detailsofrecipies=new Details(recipeimg[i],recipename[i],reciperating[i]);
            details.add(detailsofrecipies);
        }

        RecyclerView reclyclerviewrecipe=(RecyclerView)findViewById(R.id.reclyclerviewrecipe);
        RecipelistAdapter recipelistAdapter=new RecipelistAdapter(RecipeList.this,details);
        reclyclerviewrecipe.setAdapter(recipelistAdapter);
        reclyclerviewrecipe.setLayoutManager(new GridLayoutManager(RecipeList.this,2,GridLayoutManager.VERTICAL,false));

    }

    @Override
    public void onRecipeListAction(Boolean isselected) {
        if (isselected){

        }
    }
}