package dev.innov8.devboards.web.controllers;

import dev.innov8.devboards.services.UserService;
import dev.innov8.devboards.web.dtos.Credentials;
import dev.innov8.devboards.web.dtos.Principal;
import dev.innov8.devboards.web.security.JwtConfig;
import dev.innov8.devboards.web.security.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private UserService userService;

    @Autowired
    public AuthController(UserService service) {
        this.userService = service;
    }

    @PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes="application/json")
    public Principal authenticate(@RequestBody Credentials creds, HttpServletResponse resp) {
        Principal payload = userService.authenticate(creds);
        resp.setHeader(JwtConfig.HEADER, TokenGenerator.createJwt(payload));
        return payload;
    }

}
