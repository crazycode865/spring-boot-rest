package com.cameraapp.controller;

import com.cameraapp.exception.CameraNotFoundException;
import com.cameraapp.model.Camera;
import com.cameraapp.service.ICameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/camera-api")
public class CameraController {
    @Autowired
    ICameraService iCameraService;
    //http://localhost:8080/camera-api/cameras/
   @PostMapping("/cameras")
    ResponseEntity<Void> addCamera(@RequestBody Camera camera){

       iCameraService.addCamera(camera);
       ResponseEntity<Void>responseEntity=ResponseEntity.status(HttpStatus.CREATED).build();
       return responseEntity;
   }
   @PutMapping("/cameras")
   ResponseEntity<Void> updateCamera(@RequestBody Camera camera){
        iCameraService.updateCamera(camera);
        ResponseEntity<Void> responseEntity=ResponseEntity.status(HttpStatus.CREATED).build();
        return  responseEntity;
   }
   @DeleteMapping("/cameras/cameraId/{cameraId}")
   ResponseEntity<Void> deleteCamera(@PathVariable("cameraId") int cameraId){
       //System.out.println("This Camera exception");
        iCameraService.deleteCamera(cameraId);
       HttpHeaders httpHeaders = new HttpHeaders();
       httpHeaders.add("desc","deleting camera by Id");
       return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).build();
   }

    @GetMapping("/cameras")
    ResponseEntity<List<Camera>> showAllCamera()  {
       List<Camera>cameras = iCameraService.getAll();
       HttpHeaders httpHeaders = new HttpHeaders();
       httpHeaders.add("desc","Getting All cameraa");
       httpHeaders.add("info","Getting All method called");
       ResponseEntity<List<Camera>>responseEntity=new ResponseEntity(cameras,httpHeaders,HttpStatus.OK);
       return responseEntity;
    }
@GetMapping("/cameras/cameraId/{cameraId}")
ResponseEntity<Camera> getById(@PathVariable("cameraId")int cameraId){
       Camera camera = iCameraService.getById(cameraId);
       HttpHeaders httpHeaders = new HttpHeaders();
       httpHeaders.add("desc","Get Camera By Id");
       ResponseEntity<Camera> responseEntity = new ResponseEntity<>(camera,httpHeaders,HttpStatus.OK);
       return responseEntity;
}
    @GetMapping("/cameras/cameraType/{cameraType}")
    ResponseEntity<List<Camera>> showByCameraType(@PathVariable("cameraType") String cameraType) {
        List<Camera>cameras = iCameraService.getByCameraType(cameraType);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","Get Camera by CameraType");
        ResponseEntity<List<Camera>>responseEntity = new ResponseEntity(cameras,httpHeaders,HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/cameras/lens-type")
    ResponseEntity<List<Camera>> showByLensType(@RequestParam("lensType")String lensType){
        List<Camera> cameras = iCameraService.getByLensType(lensType);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","Show by Lens Type");
        ResponseEntity<List<Camera>> responseEntity=new ResponseEntity(cameras,httpHeaders,HttpStatus.OK);
        return responseEntity;
    }
    @GetMapping("/cameras/brand/{brand}/price/{price}")
     ResponseEntity<List<Camera>> showByBrandAndPrice(@PathVariable("brand")String brand,@PathVariable("price") double price){
        List<Camera> cameras = iCameraService.getByBrandAndPrice(brand,price);
        HttpHeaders httpHeaders = new HttpHeaders();
        ResponseEntity<List<Camera>> responseEntity = new ResponseEntity(cameras,httpHeaders,HttpStatus.OK);
        return responseEntity;
    }
    @GetMapping("/cameras/prices")
    ResponseEntity<List<Camera>> showByPrice(@RequestParam("price") double price){
        List<Camera> cameras = iCameraService.getByPrice(price);
        HttpHeaders httpHeaders = new HttpHeaders();
        ResponseEntity<List<Camera>>responseEntity=new ResponseEntity<>(cameras,httpHeaders,HttpStatus.OK);
        return responseEntity;
    }
}
