package com.cameraapp.model;

public enum CameraType {
    DSLR("Dslr"),SLR("Slr"),POINTANDSHOOT("Point and Shoot"),MIRRORLESS("Mirrorless");
    public  String type;

    CameraType(String type) {
        this.type = type;
    }
}
