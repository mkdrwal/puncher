package dev.mateuszkowalczyk.puncher.controller;

import dev.mateuszkowalczyk.puncher.model.LoginData;
import dev.mateuszkowalczyk.puncher.model.AuthorizationToken;
import dev.mateuszkowalczyk.puncher.response.InvalidDataResponse;
import dev.mateuszkowalczyk.puncher.response.Response;
import dev.mateuszkowalczyk.puncher.security.JwtTokenProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@RestController
@RequestMapping(value = "/api")
public class AuthController {
    private AuthenticationManager authenticationManager;
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @ResponseBody
    @PostMapping(value = "/login")
    @CrossOrigin
    public Response login(@RequestBody LoginData data, HttpServletResponse response) {
        try {
            String username = data.getUsername();
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, data.getPassword()));
            String token = jwtTokenProvider.create(username, new ArrayList<String>() {
                {
                    add("ROLE_USER");
                }
            });
            AuthorizationToken authorizationToken = new AuthorizationToken();
            authorizationToken.setUsername(username);
            authorizationToken.setToken(token);
            authorizationToken.setMessage("Successful");

            return authorizationToken;
        } catch (AuthenticationException e) {
            return new InvalidDataResponse("Invalid login data");
        }
    }


}
