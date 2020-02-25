package dev.mateuszkowalczyk.puncher.controller;

import dev.mateuszkowalczyk.puncher.entity.User;
import dev.mateuszkowalczyk.puncher.model.UserDTO;
import dev.mateuszkowalczyk.puncher.response.Response;
import dev.mateuszkowalczyk.puncher.response.SuccessfulCreateResponse;
import dev.mateuszkowalczyk.puncher.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(
            UserService userService
    ) {
        this.userService = userService;
    }

    @GetMapping(value = "/list")
    public List<User> list() {
        return this.userService.getList();
    }

    @ResponseBody
    @PostMapping(value = "/create")
    public Response create(@RequestBody UserDTO user) {
        this.userService.create(user);

        return new SuccessfulCreateResponse();
    }


}
