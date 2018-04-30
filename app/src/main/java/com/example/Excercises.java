package com.example;

/**
 * Created by Andrzej on 4/16/2018.
 *
 *This class initializes get and set methods for exercises
 */

public class Excercises {
   //setting variable names
    private int id;
    private String name;
    private int excerciselength;
    private String timetoexcercise;


//consrtuctor method
    public Excercises()
    {
    }

    public Excercises(int id,String name, int excerciselength,String timetoexcercise)
    {
        this.id=id;
        this.name=name;
        this.excerciselength=excerciselength;
        this.timetoexcercise=timetoexcercise;
    }

    public Excercises(String names, int excerciselengths,String timetoexcercise) {
        this.name=names;
        this.excerciselength=excerciselengths;
        this.timetoexcercise=timetoexcercise;
    }
//methods seting the values
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setTimetoexcercise(String timetoexcercise) {
        this.timetoexcercise = timetoexcercise;
    }
//initializing the get values for exercises
    public void setExcerciselength(int excerciselength) {
        this.excerciselength = excerciselength;
    }
    public int getId() {
        return id;
    }
    public int getExcerciselength() {
        return excerciselength;
    }
    public String getName() {
        return name;
    }
    public String getTimetoexcercise(){return timetoexcercise;}
}
