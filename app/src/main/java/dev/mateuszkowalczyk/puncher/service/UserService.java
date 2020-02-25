package dev.mateuszkowalczyk.puncher.service;

import dev.mateuszkowalczyk.puncher.model.User;
import dev.mateuszkowalczyk.puncher.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User create() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");

        this.userRepository.save(user);

        return user;
    }
}
