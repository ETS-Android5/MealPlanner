package com.example.mealplanner;

public class RecipelistDetails {

    private final int Image;
    private final String name;
    private final String ratting;
    final Boolean isselected;

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
