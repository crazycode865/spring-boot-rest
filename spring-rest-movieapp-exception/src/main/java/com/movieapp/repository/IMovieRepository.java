package com.movieapp.repository;

import com.movieapp.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IMovieRepository extends JpaRepository<Movie,Integer> {

    Movie findByMovieName(String movieName);
    List<Movie> findByGenre(String genre);
    List<Movie> findByLanguage(String language);
//    List<Movie> findByYearOfRelease(int year);
    List<Movie> findByFormat(String format);
    List<Movie> findByType(String type);
    List<Movie> findByFormatAndType(String format,String type);
    List<Movie> findByYearOfRelease(int year);
    List<Movie> findByPriceLessThan(double price);
    List<Movie> findByDuration(double duration);
    List<Movie> findByRatings(double ratings);

}
