package dev.durgesh.BookMyShow.Repository;

import dev.durgesh.BookMyShow.Model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show, Integer> {
}
