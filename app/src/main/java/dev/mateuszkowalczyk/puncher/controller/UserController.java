package dev.mateuszkowalczyk.puncher.controller;

import dev.mateuszkowalczyk.puncher.entity.User;
import dev.mateuszkowalczyk.puncher.model.UserDTO;
import dev.mateuszkowalczyk.puncher.response.CannotFindResponse;
import dev.mateuszkowalczyk.puncher.response.Response;
import dev.mateuszkowalczyk.puncher.response.SuccessfulCreateResponse;
import dev.mateuszkowalczyk.puncher.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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

    @GetMapping(value = "/{id}")
    public User get(@PathVariable Long id) {
        return this.userService.get(id);
    }

    @ResponseBody
    @PostMapping(value = "/create")
    public Response create(@RequestBody UserDTO user) {
        this.userService.create(user);

        return new SuccessfulCreateResponse();
    }

    @ExceptionHandler(NoSuchElementException.class)
    public Response cannotFindUser() {
        return new CannotFindResponse();
    }
}
