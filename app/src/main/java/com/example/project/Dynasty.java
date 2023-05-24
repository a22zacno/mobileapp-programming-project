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
}
