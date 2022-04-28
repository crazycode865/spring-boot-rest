package com.movieapp.service;

import com.movieapp.exception.MovieNotFoundException;
import com.movieapp.model.Movie;

import java.util.List;

public interface IMovieService {
     void  addMovie(Movie movie);
     void deleteMovie(int movieId);
     void updateMovie(Movie movie);
    List<Movie> getAll()throws MovieNotFoundException;
    Movie getById(int movieId)throws MovieNotFoundException;
    Movie getByMovieName(String movieName)throws MovieNotFoundException;
    List<Movie> getByGenre(String genre)throws MovieNotFoundException;
    List<Movie> getByLanguage(String language)throws MovieNotFoundException;
//    List<Movie> getByYear(int year)throws MovieNotFoundException;
    List<Movie> getByFormat(String format)throws MovieNotFoundException;
    List<Movie> getByType(String type)throws MovieNotFoundException;
    List<Movie> getByFormatAndType(String format,String type)throws MovieNotFoundException;
    List<Movie> getByYearOfRelease(int year)throws MovieNotFoundException;
    List<Movie> getByPriceLessThan(double price)throws MovieNotFoundException;
    List<Movie> getByDuration(double duration)throws MovieNotFoundException;
    List<Movie> getByRatings(double ratings)throws MovieNotFoundException;


}
