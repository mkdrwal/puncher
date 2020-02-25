package dev.mateuszkowalczyk.puncher.service;

import dev.mateuszkowalczyk.puncher.entity.User;
import dev.mateuszkowalczyk.puncher.model.UserDTO;
import dev.mateuszkowalczyk.puncher.repository.UserRepository;
import dev.mateuszkowalczyk.puncher.security.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService (
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User create(UserDTO userDTO) {
        User user = new User();

        user.setUsername(userDTO.getUsername());
        user.setPassword(this.passwordEncoder.encode(userDTO.getPlainPassword()));

        this.userRepository.save(user);
        return user;
    }

    public List<User> getList() {
        return this.userRepository.findAll();
    }

    public User get(Long id) {
        var user = this.userRepository.findById(id);
        return user.get();
    }
}
