package com.example.akashchandra.project01.Model;

/**
 * Created by Akash Chandra on 13-11-2016.
 */

public class Weekday {

    public String weekdayName;
    public String precipitationQty;
    public int ImageId;


    public Weekday(String weekdayName, String precipitationQty) {
        this.weekdayName = weekdayName;
        this.precipitationQty = precipitationQty;

    }

    public Weekday() {
    }

    public String getWeekdayName() {
        return weekdayName;
    }

    public String getPrecipitationQty() {
        return precipitationQty;
    }

    public int getImageId() {
        return ImageId;
    }

    public void setWeekdayName(String weekdayName) {
        this.weekdayName = weekdayName;
    }

    public void setPrecipitationQty(String precipitationQty) {
        this.precipitationQty = precipitationQty;
    }

    public void setImageId(int imageId) {
        ImageId = imageId;
    }
}
