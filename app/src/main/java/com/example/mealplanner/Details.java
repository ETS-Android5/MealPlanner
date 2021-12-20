package com.example.mealplanner;

public class Details {

    private final int Image;
    private final String name;
    private final String ratting;
    private final String calories;
    private final String duration;

    public Details(int image, String name, String ratting,String calories,String duration) {
        Image = image;
        this.name = name;
        this.ratting = ratting;
        this.calories=calories;
        this.duration=duration;
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

    public String getCalories() {
        return calories;
    }

    public String getDuration() {
        return duration;
    }
}
