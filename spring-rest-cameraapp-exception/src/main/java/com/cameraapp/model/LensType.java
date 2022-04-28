package com.cameraapp.model;

public enum LensType {
    ZOOM("Zoom"),WIDE("Wide") ,ANGLE("Angle"), PRIME("Prime"), TELEPHOTO("Telephoto");
    public String type;

    LensType(String type) {
        this.type = type;
    }
}
