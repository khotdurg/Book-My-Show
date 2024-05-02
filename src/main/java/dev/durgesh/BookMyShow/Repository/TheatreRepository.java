package dev.durgesh.BookMyShow.Repository;

import dev.durgesh.BookMyShow.Model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Integer> {
    Theatre findTheatreByName(String theatreName);
}
