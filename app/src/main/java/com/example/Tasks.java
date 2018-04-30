package com.example;

//Getters and Setters for calendar database
public class Tasks {
    private int id;
    private String day;
    private String task;
    private String timeofday;

    public Tasks() {

    }

    public Tasks(String day, String task,String timeofday) {
        this.day = day;
        this.task=task;
        this.timeofday=timeofday;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setDay(String day) {
        this.day = day;
    }
    public void setTask(String task) {
        this.task = task;
    }
    public void setTimeofday(String timeofday) {
        this.timeofday = timeofday;
    }

    public int getId() {
        return id;
    }
    public String getDay() {
        return day;
    }
    public String getTask() {
        return task;
    }
    public String getTimeofday(){return timeofday;}
}