package com.cameraapp.service;

import com.cameraapp.exception.CameraNotFoundException;
import com.cameraapp.model.Camera;
import com.cameraapp.repository.ICameraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CameraServiceImpl implements ICameraService {
    @Autowired
    ICameraRepository iCameraRepository;

    @Override
    public void addCamera(Camera camera) {
        iCameraRepository.save(camera);
    }

    @Override
    public void deleteCamera(int cameraId) {
        iCameraRepository.deleteById(cameraId);
    }

    @Override
    public void updateCamera(Camera camera) {
        iCameraRepository.save(camera);

    }

    @Override
    public List<Camera> getAll() {
        List<Camera> camera = iCameraRepository.findAll();
        if (camera.isEmpty())
            throw new CameraNotFoundException("Camera Not Found");
        return camera;
    }

    @Override
    public Camera getById(int cameraId) throws CameraNotFoundException {
        Camera camera = iCameraRepository.findById(cameraId);
        if (camera==null)
            throw new CameraNotFoundException("Camera Not Found");
        return camera;
    }

    @Override
    public List<Camera> getByBrandAndPrice(String brand, double price) throws CameraNotFoundException {
        List<Camera> camera = iCameraRepository.findByBrandAndPrice(brand, price);
        if (camera.isEmpty())
            throw new CameraNotFoundException("Camera Not Found");
        return camera;
    }

    @Override
    public List<Camera> getByLensType(String lensType) throws CameraNotFoundException {
        List<Camera> camera = iCameraRepository.findByLensType(lensType);
        if (camera.isEmpty())
            throw new CameraNotFoundException("Camera Not Found");
        return camera;
    }

    @Override
    public List<Camera> getByCameraType(String cameraType) throws CameraNotFoundException {
        List<Camera> camera = iCameraRepository.findByCameraType(cameraType);
        if (camera.isEmpty())
            throw new CameraNotFoundException("Camera Not Found");
        return camera;
    }

    @Override
    public List<Camera> getByPrice(double price) throws CameraNotFoundException {
        List<Camera> camera = iCameraRepository.findByPrice(price);
        if (camera.isEmpty())
            throw new CameraNotFoundException("Camera Not Found");
        return camera;
    }
}
