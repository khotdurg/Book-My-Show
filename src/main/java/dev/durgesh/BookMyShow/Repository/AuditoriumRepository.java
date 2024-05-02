package dev.durgesh.BookMyShow.Repository;

import dev.durgesh.BookMyShow.Model.Auditorium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriumRepository extends JpaRepository<Auditorium,Integer> {
    Auditorium findAuditoriumByName(String name);
}
