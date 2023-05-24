package com.example.project;

import com.google.gson.annotations.SerializedName;

public class Dynasty {
    private String ID;
    private String name;
    @SerializedName("location")
    private String capital;
    @SerializedName("size")
    private int establish;
    @SerializedName("cost")
    private int disestablish;
    @SerializedName("auxdata")
    private String wikipedia;

    public String getName(){
      return name;
    }

    public String getCapital(){
        return capital;
    }

    public int getEstablish(){
        return establish;
    }

    public int getDisestablish(){
        return disestablish;
    }

    public String getWikipedia(){
        return wikipedia;
    }
}
