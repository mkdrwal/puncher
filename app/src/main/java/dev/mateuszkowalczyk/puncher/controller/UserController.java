package dev.mateuszkowalczyk.puncher.controller;

import dev.mateuszkowalczyk.puncher.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/create")
    public boolean createUser() {
        this.userService.create();

        return false;
    }

}
