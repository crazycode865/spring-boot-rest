package com.cameraapp.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Camera {
    @Id
    @GeneratedValue(generator = "camera_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "camera_gen",sequenceName = "camera_seq",initialValue = 1,allocationSize = 1)
    private Integer cameraId;
    private String model;
    private String brand;
    private String cameraType;
    private String lensType;
    private double price;
}
