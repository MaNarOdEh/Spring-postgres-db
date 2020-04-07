package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.example.demo.exceptions.ExceededTheLimitForAddingMoviesToFavorites;
import com.example.demo.exceptions.MovieEntityFound;
import com.example.demo.exceptions.MovieNotFoundException;
import com.example.demo.model.Movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.repository.MovieRepository;
import com.example.demo.services.servicesInterface.MovieServices;

@Service
public class MovieServicesImp implements MovieServices {
    @Autowired
    private MovieRepository movieRepository;
    public static final String MOVIECHACHEKEY_STRING = "movieCache";

    /**
     * This method will take an movie object and try to save it.
     * 
     * @param Movie
     * @return boolean
     * 
     * @throws ExceededTheLimitForAddingMoviesToFavorites exception when the user
     *                                                    have more than 5 fav movie
     * 
     * @throws MovieEntityFound                           when the movieId is
     *                                                    already Found
     */
    @Override
    public boolean addMovie(Movie movie) {
        List<Movie> mvoies = getUserMovie(movie.getPerson().getId());
        if (mvoies.size() == 5) {
            throw new ExceededTheLimitForAddingMoviesToFavorites(movie.getMovieId());
        }
        Optional<Movie> result = mvoies.stream().filter(mo -> movie.getMovieId().equals(mo.getMovieId())).findAny();

        if (result.isPresent()) {
            throw new MovieEntityFound(movie.getMovieId());
        }
        return movieRepository.save(movie) != null;
    }

    @Override
    @Transactional
    public void deleteMovie(UUID personId, String movieId) {
        int result = movieRepository.deleteByPersonIdAndMovieId(personId, movieId);
        if (result == 0) {
            throw new MovieNotFoundException(movieId);
        }
    }

    @Override
    public void deleteMovieById(UUID id) {
        movieRepository.deleteById(id);
    }

    @Override
    @Cacheable(value = "cache-movie", key = "#root.target.MOVIECHACHEKEY_STRING+#userId")
    public List<Movie> getUserMovie(UUID userId) {
        System.out.println(userId + "  " + " userMovie");
        List<Movie> movie = movieRepository.findByPersonId(userId);
        return movie;
    }

    @Override
    @CacheEvict(value = "cache-movie-page", key = "'moviepage'+#pageNo+#pageSize+#sortBy", allEntries = true)
    public List<Movie> getUserMovies(UUID userId, Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending());
        Page<Movie> pagedResult = movieRepository.findByPersonId(userId, paging);
        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Movie>();
        }

    }

    @Override
    public List<Movie> getMoviesStartWithChars(UUID userId, Character ch) {
        List<Movie> movie = movieRepository.findByPersonId(userId);
        return movie.stream().filter(mov -> mov.getMovieId().startsWith("s")).collect(Collectors.toList());
    }

}