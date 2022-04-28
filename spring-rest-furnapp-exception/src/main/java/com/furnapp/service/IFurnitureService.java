package com.furnapp.service;

import com.furnapp.exception.FurnitureNotFoundException;
import com.furnapp.model.Category;
import com.furnapp.model.Furniture;
import com.furnapp.model.Style;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IFurnitureService {
    public void addFurniture(Furniture furniture);
    public void deleteFurniture(int furnitureId);
    public void updateFurniture(Furniture furniture);

    Furniture getById(int furnitureId) throws FurnitureNotFoundException;
    List<Furniture>getAll();
    List<Furniture> getByCategory(Category category)throws FurnitureNotFoundException;
    List<Furniture> getByMaterial(String material)throws FurnitureNotFoundException;
    List<Furniture> getByStyle(Style style)throws FurnitureNotFoundException;
    List<Furniture> getByBrand(String brand)throws FurnitureNotFoundException;
    List<Furniture> getByRoomType(String roomType)throws FurnitureNotFoundException;
    List<Furniture> getByStorageAvailable(boolean storage)throws FurnitureNotFoundException;


    //Custom Query
    List<Furniture> getByPriceRange(int minPrice,double maxPrice)throws FurnitureNotFoundException;
    List<Furniture> getByMatAndBrand(String material,String brand)throws FurnitureNotFoundException;
    List<Furniture> getByRoomAndCategory(String roomType, Category category)throws FurnitureNotFoundException;
    Integer getTotal();
    Integer getCategoryCost(Category category);
}
