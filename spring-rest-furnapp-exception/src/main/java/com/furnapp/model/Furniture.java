package com.furnapp.model;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@NamedQuery(name="findCategoryCost",
        query="Select f.price from Furniture f where f.category=?1")
//@Table(name = "newfurniture")
public class Furniture{
    private String name;
    @Enumerated(EnumType.STRING)
    private Category category;
    private  String roomType;
    private  String material;
    @Id
    @GeneratedValue(generator = "furn_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name="furn_gen",sequenceName = "furn_sequence",initialValue = 100,allocationSize = 2)
    private  Integer furnitureId;
    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private Style style;
    @Column(length = 20)
    private String brand;
    private  double price;
    private  boolean storageAvailable;

    public Furniture(String name, Category category, String roomType, String material, Style style, String brand, double price, boolean storageAvailable) {
        this.name = name;
        this.category = category;
        this.roomType = roomType;
        this.material = material;
        this.style = style;
        this.brand = brand;
        this.price = price;
        this.storageAvailable = storageAvailable;
    }
}
