package com.movieapp.controller;

import com.movieapp.model.Movie;
import com.movieapp.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie-api")
public class MovieController {
    @Autowired
    IMovieService iMovieService;
    @PostMapping("/movies")
    ResponseEntity<Void> addMovie(@RequestBody Movie movie){
        iMovieService.addMovie(movie);
        ResponseEntity<Void> responseEntity=ResponseEntity.status(HttpStatus.CREATED).build();
        return  responseEntity;
    }
    @DeleteMapping("/movies/movie-id/")
    ResponseEntity<Void> deleteMovie(@RequestParam("movieId")int movieId){
        iMovieService.deleteMovie(movieId);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","Deleting by Id ");
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).build();
    }
    @PutMapping("/movies")
    ResponseEntity<Void> updateMovie(@RequestBody Movie movie){
        iMovieService.updateMovie(movie);
        ResponseEntity<Void> responseEntity=ResponseEntity.status(HttpStatus.CREATED).build();
        return  responseEntity;
    }

    @GetMapping("/movies")
    ResponseEntity<List<Movie>> showAllMovies(){
        List<Movie> movies= iMovieService.getAll();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","Getting movie By Year");
        ResponseEntity<List<Movie>>responseEntity=new ResponseEntity<>(movies,httpHeaders, HttpStatus.OK);
        return  responseEntity;
    }
    @GetMapping("/movies/movie-id/{movieId}")
    ResponseEntity<Movie> getById(@PathVariable("movieId")int movieId){
        Movie movie = iMovieService.getById(movieId);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","Getting movie By Year");
        ResponseEntity<Movie>responseEntity=new ResponseEntity<>(movie,httpHeaders, HttpStatus.OK);
        return  responseEntity;
    }
    @GetMapping("/movies/movieName/{movieName}")
    ResponseEntity<  Movie >showByMovieName(@PathVariable("movieName")String movieName){
        Movie movie = iMovieService.getByMovieName(movieName);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","Getting movie By Year");
        ResponseEntity<Movie>responseEntity=new ResponseEntity<>(movie,httpHeaders, HttpStatus.OK);
        return  responseEntity;
    }
    @GetMapping("/movies/genres/{genre}")
    ResponseEntity<  List<Movie> >showByGenre(@PathVariable("genre")String genre){
        List<Movie> movies= iMovieService.getByGenre(genre);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","Getting movie By Year");
        ResponseEntity<List<Movie>>responseEntity=new ResponseEntity<>(movies,httpHeaders, HttpStatus.OK);
        return  responseEntity;
    }
    @GetMapping("/movies/language/{language}")
    ResponseEntity<  List<Movie> >showByLanguage(@PathVariable("language")String language){
        List<Movie> movies= iMovieService.getByLanguage(language);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","Getting movie By Year");
        ResponseEntity<List<Movie>>responseEntity=new ResponseEntity<>(movies,httpHeaders, HttpStatus.OK);
        return  responseEntity;
    }
    @GetMapping("/movies/type/{type}")
    ResponseEntity<  List<Movie> >showByType(@PathVariable("type")String type){
        List<Movie> movies= iMovieService.getByType(type);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","Getting movie By Year");
        ResponseEntity<List<Movie>>responseEntity=new ResponseEntity<>(movies,httpHeaders, HttpStatus.OK);
        return  responseEntity;
    }
    @GetMapping("/movies/formats/{format}")
    ResponseEntity<  List<Movie>> showByFormat(@PathVariable("format")String format){
        List<Movie> movies= iMovieService.getByFormat(format);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","Getting movie By Year");
        ResponseEntity<List<Movie>>responseEntity=new ResponseEntity<>(movies,httpHeaders, HttpStatus.OK);
        return  responseEntity;
    }
    @GetMapping("/movies/format/type/{type}")
    ResponseEntity<  List<Movie> >showByFormatAndType(@PathVariable("format")String format,@RequestParam("type")String type){
        List<Movie> movies= iMovieService.getByFormatAndType(format,type);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","Getting movie By Year");
        ResponseEntity<List<Movie>>responseEntity=new ResponseEntity<>(movies,httpHeaders, HttpStatus.OK);
        return  responseEntity;
    }
    @GetMapping("/movies/price/{price}")
    ResponseEntity<  List<Movie> >showByPriceLessThan(@PathVariable("price")double price){
        List<Movie> movies= iMovieService.getByPriceLessThan(price);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","Getting movie By Year");
        ResponseEntity<List<Movie>>responseEntity=new ResponseEntity<>(movies,httpHeaders, HttpStatus.OK);
        return  responseEntity;

    }
    @GetMapping("/movies/duration/{duration}")
    ResponseEntity<  List<Movie>> showByDuration(@PathVariable("duration")double duration){
        List<Movie> movies=iMovieService.getByDuration(duration);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","Getting movie By Year");
        ResponseEntity<List<Movie>>responseEntity=new ResponseEntity<>(movies,httpHeaders, HttpStatus.OK);
        return  responseEntity;
    }
    @GetMapping("/movies/ratings/{ratings}")
    ResponseEntity< List<Movie>> showByRatings(@PathVariable("ratings")double ratings){
        List<Movie> movies=iMovieService.getByRatings(ratings);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","Getting movie By Year");
        ResponseEntity<List<Movie>>responseEntity=new ResponseEntity<>(movies,httpHeaders, HttpStatus.OK);
        return  responseEntity;
    }
    @GetMapping("/movies/yearOfRelease/{yearOfRelease}")
    ResponseEntity<List<Movie>> showByYearOfRelease(@PathVariable("yearOfRelease")int yearOfRelease){
        List<Movie> movies=iMovieService.getByYearOfRelease(yearOfRelease);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","Getting movie By Year");
        ResponseEntity<List<Movie>>responseEntity=new ResponseEntity<>(movies,httpHeaders, HttpStatus.OK);
        return  responseEntity;
    }
}
