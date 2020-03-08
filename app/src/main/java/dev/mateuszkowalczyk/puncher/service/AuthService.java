package dev.mateuszkowalczyk.puncher.service;

import dev.mateuszkowalczyk.puncher.entity.User;
import dev.mateuszkowalczyk.puncher.model.RegisterDTO;
import dev.mateuszkowalczyk.puncher.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private UserService userService;

    @Autowired
    public AuthService(UserService userService) {

        this.userService = userService;
    }

    public User register(RegisterDTO data) {
        UserDTO userDTO = getUserDTO(data);

        return this.userService.create(userDTO);
    }

    private UserDTO getUserDTO(RegisterDTO data) {
        return new UserDTO(data);
    }
}
