package dev.durgesh.BookMyShow.Repository;

import dev.durgesh.BookMyShow.Model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {
}
