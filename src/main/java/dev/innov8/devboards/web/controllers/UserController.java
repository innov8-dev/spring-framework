package dev.innov8.devboards.web.controllers;

import dev.innov8.devboards.entities.AppUser;
import dev.innov8.devboards.services.UserService;
import dev.innov8.devboards.web.dtos.AppUserDTO;
import dev.innov8.devboards.web.security.Secured;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService service) {
        this.userService = service;
    }

    @GetMapping
    @Secured(allowedRoles={"Admin", "Dev"})
    public List<AppUserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value="/id/{id}")
    public AppUserDTO getUserById(@PathVariable int id, HttpServletRequest req) {
        return userService.getUserById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public AppUserDTO registerNewUser(@RequestBody AppUser newUser) {
        return userService.register(newUser);
    }
}

