package com.cameraapp.service;

import com.cameraapp.exception.CameraNotFoundException;
import com.cameraapp.model.Camera;

import java.util.List;

public interface ICameraService {
    void addCamera(Camera camera);
    void deleteCamera(int cameraId);
    void updateCamera(Camera camera);
    List<Camera> getAll()throws CameraNotFoundException;
    Camera getById(int cameraId)throws CameraNotFoundException;
    List<Camera>getByBrandAndPrice(String brand,double price)throws CameraNotFoundException;
    List<Camera> getByLensType(String lensType)throws CameraNotFoundException;
    List<Camera> getByCameraType(String cameraType)throws CameraNotFoundException;
    List<Camera>getByPrice(double price)throws CameraNotFoundException;

}
