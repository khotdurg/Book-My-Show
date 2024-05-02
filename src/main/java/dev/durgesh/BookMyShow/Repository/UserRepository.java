package dev.durgesh.BookMyShow.Repository;

import dev.durgesh.BookMyShow.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserByEmail(String email);

}
