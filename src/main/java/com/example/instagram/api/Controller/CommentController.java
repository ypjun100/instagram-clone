package com.example.instagram.api.Controller;

import com.example.instagram.api.Entity.Comment;
import com.example.instagram.api.Service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping("{post_id}")
    public List<Comment> retrieve(@PathVariable long post_id) {
        return commentService.findCommentsByPostId(post_id);
    }

    @PostMapping("write")
    public Boolean write(@RequestParam String user_id, @RequestParam String content, @RequestParam long post_id) {
        return commentService.write(user_id, content, post_id);
    }

    @PutMapping("{id}")
    public boolean update(@PathVariable long id, @RequestParam String content) {
        return commentService.update(id, content);
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable long id) {
        return commentService.delete(id);
    }
}
