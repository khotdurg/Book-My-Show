package dev.durgesh.BookMyShow.Service;

import dev.durgesh.BookMyShow.Model.User;
import dev.durgesh.BookMyShow.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;

import java.util.ArrayList;

import static javax.swing.text.html.HTML.Tag.U;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

}