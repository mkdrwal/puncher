package dev.mateuszkowalczyk.puncher.service;

import dev.mateuszkowalczyk.puncher.model.RegisterData;
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

    public void register(RegisterData data) {
        UserDTO userDTO = new UserDTO(data);

        this.userService.create(userDTO);
    }
}
