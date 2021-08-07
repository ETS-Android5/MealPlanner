package com.example.mealplanner;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class CategoryAdapter extends BaseAdapter {

    private HomeFragment context;
    private LayoutInflater inflater;
    int[] cat_type_img;

    CategoryAdapter(HomeFragment c,int[] cat_type_img){
        context=c;
        this.cat_type_img=cat_type_img;
    }

    @Override
    public int getCount() {
        return cat_type_img.length;
    }

    @Override
    public Object getItem(int position) {
        return getItemId(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        inflater = context.getActivity().getLayoutInflater();

        if (view==null) {
            view = inflater.inflate(R.layout.category_row, null);
        }

        ImageView cat_image_type=view.findViewById(R.id.item_category_image);
        cat_image_type.setImageResource(cat_type_img[position]);

        return view;
    }
}
