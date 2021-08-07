package com.example.mealplanner;

public class RecipelistDetails {

    private int Image;
    private String name;
    private String ratting;
    private Boolean isselected=false;


    public RecipelistDetails(int image, String name, String ratting, Boolean isselected) {
        Image = image;
        this.name = name;
        this.ratting = ratting;
        this.isselected = isselected;
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
