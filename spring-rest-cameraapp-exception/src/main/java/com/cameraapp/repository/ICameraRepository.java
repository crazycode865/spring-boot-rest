package com.cameraapp.repository;

import com.cameraapp.model.Camera;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICameraRepository extends JpaRepository<Camera,Integer> {

    List<Camera> findAll();
    Camera findById(int cameraId);
    List<Camera>findByBrandAndPrice(String brand,double price);
    List<Camera> findByLensType(String lensType);
    List<Camera> findByCameraType(String cameraType);
    List<Camera>findByPrice(double price);
}
