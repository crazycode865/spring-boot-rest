package com.furnapp.model;

public enum RoomType {
    BED("Bed Room"),
    OFFICE("Office Room"),
    DINING("Dining Room"),
    STUDY("Study Room"),
    KIDS("Kids Room"),
    LIVING("Living Room"),
    GUEST("Guest Room");

    public  String type;

    RoomType(String type) {
        this.type = type;
    }
}
