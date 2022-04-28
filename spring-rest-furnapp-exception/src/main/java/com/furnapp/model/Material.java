package com.furnapp.model;

public enum Material {
    WOOD(1,"Teak wood"),
    PLASTIC(2,"Plastic"),
    SWOOD(3,"Shesham Wood");

    public int grade;
    public String type;

    Material(int grade, String type) {
        this.grade = grade;
        this.type = type;
    }
}
