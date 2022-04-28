package com.movieapp.service;

import com.movieapp.exception.MovieNotFoundException;
import com.movieapp.model.Movie;
import com.movieapp.repository.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements IMovieService {
    @Autowired
    IMovieRepository iMovieRepository;

    @Override
    public void addMovie(Movie movie) {
        iMovieRepository.save(movie);
    }

    @Override
    public void deleteMovie(int movieId) {
        iMovieRepository.deleteById(movieId);
    }

    @Override
    public void updateMovie(Movie movie) {
        iMovieRepository.save(movie);
    }

    @Override
    public List<Movie> getAll() {
        List<Movie> movies = iMovieRepository.findAll();
        if (movies.isEmpty())
            throw new MovieNotFoundException("Movie not Found");
        return movies;
    }

    @Override
    public Movie getById(int movieId) {
        return iMovieRepository.findById(movieId).stream().findAny().orElseThrow(() -> new MovieNotFoundException("Movie Not Found"));
    }


    @Override
    public Movie getByMovieName(String movieName) {
        Movie movie = iMovieRepository.findByMovieName(movieName);
        if (movie!=null)
            return movie;
        throw new MovieNotFoundException("Movie Name not Found");
    }

    @Override
    public List<Movie> getByGenre(String genre) {

        List<Movie> movies = iMovieRepository.findByGenre(genre);
        if (movies.isEmpty())
            throw new MovieNotFoundException("Movie not Found");
        return movies;
    }

    @Override
    public List<Movie> getByLanguage(String language) {
        List<Movie> movies = iMovieRepository.findByLanguage(language);
        if (movies.isEmpty())
            throw new MovieNotFoundException("Movie not Found");
        return movies;

    }
    @Override
    public List<Movie> getByFormat(String format) {
        List<Movie> movies = iMovieRepository.findByFormat(format);
        if (movies.isEmpty())
            throw new MovieNotFoundException("Movie not Found");
        return movies;
    }

    @Override
    public List<Movie> getByType(String type) {

        List<Movie> movies = iMovieRepository.findByType(type);
        if (movies.isEmpty())
            throw new MovieNotFoundException("Movie not Found");
        return movies;
    }

    @Override
    public List<Movie> getByFormatAndType(String format, String type) {
        List<Movie> movies = iMovieRepository.findByFormatAndType(format, type);
        if (movies.isEmpty())
            throw new MovieNotFoundException("Movie not Found");
        return movies;
    }

    @Override
    public List<Movie> getByYearOfRelease(int year) {
        List<Movie> movies = iMovieRepository.findByYearOfRelease(year);
        if (movies.isEmpty())
            throw new MovieNotFoundException("Movie not Found");
        return movies;
    }

    @Override
    public List<Movie> getByPriceLessThan(double price) {
        List<Movie> movies = iMovieRepository.findByPriceLessThan(price);
        if (movies.isEmpty())
            throw new MovieNotFoundException("Movie not Found");
        return movies;
    }

    @Override
    public List<Movie> getByDuration(double duration) {
        List<Movie> movies = iMovieRepository.findByDuration(duration);
        if (movies.isEmpty())
            throw new MovieNotFoundException("Movie not Found");
        return movies;
    }

    @Override
    public List<Movie> getByRatings(double ratings) throws MovieNotFoundException {
        List<Movie> movies = iMovieRepository.findByRatings(ratings);
        if (movies.isEmpty())
            throw new MovieNotFoundException("Movie not Found");
        return movies;
    }
}
