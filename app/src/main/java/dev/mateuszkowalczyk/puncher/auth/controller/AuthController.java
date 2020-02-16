package dev.mateuszkowalczyk.puncher.auth.controller;

import dev.mateuszkowalczyk.puncher.auth.model.LoginData;
import dev.mateuszkowalczyk.puncher.auth.model.LoginToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class AuthController {

    @ResponseBody
    @RequestMapping(value = "/login")
    public LoginToken login(@RequestBody LoginData data, HttpServletResponse response) {

        if (
                data.getUsername() != null &&
                data.getPassword() != null &&
                data.getUsername().equals("admin") &&
                data.getPassword().equals("admin"))
        {
            LoginToken token = new LoginToken();
            token.setUsername("admin");
            token.setToken("aaaaa");

            return token;
        }
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return null;
    }


}
