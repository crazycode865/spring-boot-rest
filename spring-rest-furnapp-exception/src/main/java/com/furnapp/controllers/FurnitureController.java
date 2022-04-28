package com.furnapp.controllers;

import com.furnapp.exception.FurnitureNotFoundException;
import com.furnapp.model.Category;
import com.furnapp.model.Furniture;
import com.furnapp.model.Style;
import com.furnapp.service.IFurnitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/furniture-api")
public class FurnitureController {
    @Autowired
    IFurnitureService iFurnitureService;
   @PostMapping("/furnitures")
    public ResponseEntity<Void> addFurniture(@RequestBody Furniture furniture) {
        iFurnitureService.addFurniture(furniture);
        ResponseEntity<Void> responseEntity =
                ResponseEntity.status(HttpStatus.CREATED).build();
        return responseEntity;
    }

    @DeleteMapping("/furnitures/furnitureId/{furnitureId}")
    public ResponseEntity<Void> deleteFurniture(@PathVariable("furnitureId") int furnitureId)   {
        iFurnitureService.deleteFurniture(furnitureId);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "deleting the furniture by Id");
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).build();
    }

    @PutMapping("/furnitures")
    public ResponseEntity<Void> updateFurniture(@RequestBody Furniture furniture) {
        iFurnitureService.updateFurniture(furniture);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @GetMapping("/furnitures")
    public ResponseEntity<List<Furniture>> getAll() {
        List<Furniture> furnitures = iFurnitureService.getAll();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "getting all furniture");
        httpHeaders.add("info", "Get All Method called");
        ResponseEntity<List<Furniture>> furnitureResponse =
                new ResponseEntity(furnitures, httpHeaders, HttpStatus.OK);
        return furnitureResponse;
    }

    @GetMapping("/furnitures/furnitureId/")
    ResponseEntity<Furniture> getById(@RequestParam("furnitureId") int furnitureId) throws FurnitureNotFoundException {
        Furniture furniture = iFurnitureService.getById(furnitureId);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "getting furniture by Id");
        ResponseEntity<Furniture> furnitureResponse =
                new ResponseEntity(furniture, httpHeaders, HttpStatus.OK);
        return furnitureResponse;
    }

    @GetMapping("/furnitures/category/")
    ResponseEntity<List<Furniture>> getByCategory(@RequestParam("category") Category category) throws FurnitureNotFoundException {
        List<Furniture> furnitures = iFurnitureService.getByCategory(category);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "getting furniture by category");
        ResponseEntity<List<Furniture>> furnitureResponse =
                new ResponseEntity(furnitures, httpHeaders, HttpStatus.OK);
        return furnitureResponse;
    }

    @GetMapping("/furnitures/material/")
    ResponseEntity<List<Furniture>> getByMaterial(@RequestParam("material") String material) throws FurnitureNotFoundException {
        List<Furniture> furnitures = iFurnitureService.getByMaterial(material);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "getting furniture by material");
        ResponseEntity<List<Furniture>> furnitureResponse =
                new ResponseEntity(furnitures, httpHeaders, HttpStatus.OK);
        return furnitureResponse;
    }

    @GetMapping("/furnitures/style/")
    ResponseEntity<List<Furniture>> getByStyle(@RequestParam("style") Style style) throws FurnitureNotFoundException {
        List<Furniture> furnitures = iFurnitureService.getByStyle(style);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "getting furniture by Style");
        ResponseEntity<List<Furniture>> furnitureResponse =
                new ResponseEntity(furnitures, httpHeaders, HttpStatus.OK);
        return furnitureResponse;
    }

    @GetMapping("/furnitures/brand/")
    ResponseEntity<List<Furniture>> getByBrand(@RequestParam("nbrand") String nbrand) throws FurnitureNotFoundException {
        List<Furniture> furnitures = iFurnitureService.getByBrand(nbrand);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "getting furniture by brand");
        ResponseEntity<List<Furniture>> furnitureResponse =
                new ResponseEntity(furnitures, httpHeaders, HttpStatus.OK);
        return furnitureResponse;
    }

    @GetMapping("/furnitures/roomType/")
    ResponseEntity<List<Furniture>> getByRoomType(@RequestParam("roomType") String roomType) throws FurnitureNotFoundException {
        List<Furniture> furnitures = iFurnitureService.getByRoomType(roomType);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "getting furniture by RoomType");
        ResponseEntity<List<Furniture>> furnitureResponse =
                new ResponseEntity(furnitures, httpHeaders, HttpStatus.OK);
        return furnitureResponse;
    }

    @GetMapping("/furnitures/storageAvailable/")
    ResponseEntity<List<Furniture>> getByStorageAvailable(@RequestParam("storageAvailable") boolean storageAvailable) throws FurnitureNotFoundException {
        List<Furniture> furnitures = iFurnitureService.getByStorageAvailable(storageAvailable);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "getting furniture by Avaialability");
        ResponseEntity<List<Furniture>> furnitureResponse =
                new ResponseEntity(furnitures, httpHeaders, HttpStatus.OK);
        return furnitureResponse;
    }
    @GetMapping("/furnitures/minPrice/maxPrice/")
    ResponseEntity<List<Furniture>> getByPriceRange(@RequestParam("minPrice") int minPrice,@RequestParam("maxPrice") double maxPrice) throws FurnitureNotFoundException {
        List<Furniture> furnitures = iFurnitureService.getByPriceRange(minPrice,maxPrice);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "getting furniture by price Range");
        ResponseEntity<List<Furniture>> furnitureResponse =
                new ResponseEntity(furnitures, httpHeaders, HttpStatus.OK);
        return furnitureResponse;
    }
    @GetMapping("/furnitures/material/brand/")
    ResponseEntity<List<Furniture>> getByMatAndBrand(@RequestParam("material") String material,@RequestParam("brand") String brand) throws FurnitureNotFoundException {
        List<Furniture> furnitures = iFurnitureService.getByMatAndBrand(material,brand);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "getting furniture by Mat and Brand");
        ResponseEntity<List<Furniture>> furnitureResponse =
                new ResponseEntity(furnitures, httpHeaders, HttpStatus.OK);
        return furnitureResponse;
    }
    @GetMapping("/furnitures/roomType/category/")
    ResponseEntity<List<Furniture> >getByRoomAndCategory(@RequestParam("roomType") String roomType,@RequestParam("category") Category category) throws FurnitureNotFoundException {
        List<Furniture> furnitures = iFurnitureService.getByRoomAndCategory(roomType,category);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "getting furniture by roomType and category");
        ResponseEntity<List<Furniture>> furnitureResponse =
                new ResponseEntity(furnitures, httpHeaders, HttpStatus.OK);
        return furnitureResponse;
    }
//    @GetMapping("/furnitures")
//    ResponseEntity<Integer> getTotal(){
//        int total = iFurnitureService.getTotal();
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("desc", "getting Total");
//        ResponseEntity<Integer>furnitureResponse =
//                new ResponseEntity(total, httpHeaders, HttpStatus.OK);
//        return furnitureResponse;
//    }
}
