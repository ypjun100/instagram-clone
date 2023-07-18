package com.example.instagram.Controller;

import com.example.instagram.Service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.example.instagram.Entity.Post;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/test")
    public String main() {
        return "index";
    }

    @PostMapping("/write")
    public String write(@RequestBody String content) {
        postService.write(content);
        return content;
    }

    @GetMapping("/view")
    public List<Post> view() { return postService.findAll(); }

    @PostMapping("/finduser")
    public Post findUser(@RequestBody String content) { return postService.findByContent(content); }
}
