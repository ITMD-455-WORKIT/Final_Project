package com.example;

/**
 * Created by Andrzej on 4/25/2018.
 */

public class Utils {

//Method used to format the time value set of excercises
    public static String formatTime(String hour, String minute, String ampm){
//setign string builder value
        StringBuilder builder = new StringBuilder();
//setting hour time if it is less then 10 to add a 0 in front
        if(Integer.parseInt(hour) < 10){
            hour = "0" + hour;
        }
//code to format correctly as clock time code
        if(Integer.parseInt(minute) < 10){
            minute = "0" + minute;
        }
//stingbuilder method used to formulate string for time
        builder.append(hour).append(":").append(minute).append(" ").append(ampm);
//return the built string
        return builder.toString();


    }



}
