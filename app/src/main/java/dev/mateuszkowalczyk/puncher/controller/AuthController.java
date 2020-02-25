package dev.mateuszkowalczyk.puncher.controller;

import dev.mateuszkowalczyk.puncher.model.LoginData;
import dev.mateuszkowalczyk.puncher.model.LoginToken;
import dev.mateuszkowalczyk.puncher.response.InvalidDataResponse;
import dev.mateuszkowalczyk.puncher.response.Response;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class AuthController {

    @ResponseBody
    @RequestMapping(value = "/login")
    @CrossOrigin
    public Response login(@RequestBody LoginData data, HttpServletResponse response) {

        if (
                data.getUsername() != null &&
                data.getPassword() != null &&
                data.getUsername().equals("admin") &&
                data.getPassword().equals("admin"))
        {
            LoginToken token = new LoginToken();
            token.setUsername("admin");
            token.setToken("aaaaa");
            token.setMessage("Successful");

            return token;
        }
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return new InvalidDataResponse("Invalid login data");
    }


}
