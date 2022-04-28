package com.movieapp.model;

public enum Format {
    IMAX("Imax-3D"),THREED("3D"),TWOD("2D"),SCREENX3D("3D-Screen X");
    public String type;

    Format(String type) {
        this.type = type;
    }
}
