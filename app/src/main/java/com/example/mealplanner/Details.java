package com.example.mealplanner;

public class Details {

    private int Image;
    private String name;
    private String ratting;

    public Details(int image, String name, String ratting) {
        Image = image;
        this.name = name;
        this.ratting = ratting;
    }


    public int getImage() {
        return Image;
    }

    public String getName() {
        return name;
    }

    public String getRatting() {
        return ratting;
    }
}
