package com.example.mealplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class RecipeInDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_in_detail);

        ImageView rec_img;
        TextView rec_name,rec_cal,rec_rat,rec_duration;

        rec_img=findViewById(R.id.rec_img);
        rec_name=findViewById(R.id.rec_name);
        rec_cal=findViewById(R.id.rec_cal);
        rec_duration=findViewById(R.id.rec_duration);
        rec_rat=findViewById(R.id.rec_ratting);

        Picasso.get().load(getIntent().getIntExtra("recipeimage",0))
        .fit()
        .into(rec_img);
        rec_name.setText(getIntent().getStringExtra("recipename"));
        rec_cal.setText(getIntent().getStringExtra("reccal"));
        rec_duration.setText(getIntent().getStringExtra("recipeduration"));
        rec_rat.setText(getIntent().getStringExtra("recratting"));

    }
}