package dev.innov8.devboards.web.controllers;

import dev.innov8.devboards.entities.Post;
import dev.innov8.devboards.exceptions.ResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @GetMapping
    public List<Post> getAllPosts() {
        throw new ResourceNotFoundException();
    }

}
