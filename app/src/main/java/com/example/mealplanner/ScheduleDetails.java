package com.example.mealplanner;

public class ScheduleDetails {

    private final int Image;
    private final String name;
    private final String ratting;
    private final String calories;
    private final String duration;
    private final String schedule_time;

    public ScheduleDetails(int image, String name, String ratting,String calories, String duration,String schedule_time) {

        Image = image;
        this.name = name;
        this.ratting = ratting;
        this.calories=calories;
        this.duration = duration;
        this.schedule_time=schedule_time;

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

    public String getDuration() {
        return duration;
    }

    public String getCalories() {
        return calories;
    }

    public String getSchedule_time() {
        return schedule_time;
    }
}