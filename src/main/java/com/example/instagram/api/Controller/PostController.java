package com.example.instagram.api.Controller;

import com.example.instagram.api.Entity.Post;
import com.example.instagram.api.Service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("posts")
    public List<Post> posts() {
        return postService.retrieveAll();
    }

    @GetMapping("post/{id}")
    public Post retrieve(@PathVariable long id) {
        return postService.retrieve(id);
    }

    @PostMapping("post/write")
    public long write(@RequestParam String photos, @RequestParam String description) {
        return postService.write(photos, description);
    }

    @PutMapping("post/{id}")
    public long update(@PathVariable long id, String photos, String description) {
        return postService.update(id, photos, description);
    }

    @DeleteMapping("post/{id}")
    public Boolean delete(@PathVariable long id) {
        return postService.delete(id);
    }
}
