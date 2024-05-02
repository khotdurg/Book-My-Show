package dev.durgesh.BookMyShow.Repository;

import dev.durgesh.BookMyShow.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Movie findMovieByName(String movieName);

}
