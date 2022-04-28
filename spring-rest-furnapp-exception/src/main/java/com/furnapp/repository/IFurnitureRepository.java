package com.furnapp.repository;

import com.furnapp.exception.FurnitureNotFoundException;
import com.furnapp.model.Category;
import com.furnapp.model.Furniture;
import com.furnapp.model.Style;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
@Repository
public interface IFurnitureRepository extends JpaRepository<Furniture, Integer> {




    List<Furniture> findByMaterial(String material);
    List<Furniture> findByStyle(Style style);
    List<Furniture> findByBrand(String brand);
    List<Furniture> findByRoomType(String roomType);
    List<Furniture> findByStorageAvailable(boolean storage);
    List<Furniture> findByCategory(Category category);
    List<Furniture>findAll();



    //Custom Query
    @Query(value = "Select * from furniture where price between ?1 and ?2",nativeQuery = true)
    List<Furniture> findByPriceRange(int minPrice,double maxPrice);
    @Query("from Furniture f where f.material=?1 and f.brand=?2")
    List<Furniture> findByMatAndBrand(String material,String brand);
    @Query("from Furniture f where f.roomType=?1 and f.category=?2")
    List<Furniture> findByRoomAndCategory(String roomType,Category category);
    @Query(value="Select count(*) from furniture",nativeQuery = true)
    Integer findTotal();
    @Query(name="findCategoryCost")
    Integer findCategoryCost(Category category);


}
