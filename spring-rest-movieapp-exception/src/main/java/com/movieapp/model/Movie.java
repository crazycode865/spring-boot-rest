package com.movieapp.model;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Movie {
    @Id
    @GeneratedValue(generator = "movie_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "movie_gen",sequenceName = "movie_seq",initialValue = 1,allocationSize = 1)
    private Integer movieId;
    private String movieName;
    private String genre;
    private String language;
    private String type;
   private String format;
   private double duration;
   private double price;
   private double ratings;
    private int yearOfRelease;
   private String city;

}
