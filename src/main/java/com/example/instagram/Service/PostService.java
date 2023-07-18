package com.example.instagram.Service;

import com.example.instagram.Entity.Post;
import com.example.instagram.Repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public void write(String content) {
        Post post = new Post();
        post.setContent(content);
        postRepository.save(post);
    }

    public List<Post> findAll() { return postRepository.findAll(); }
    public Post findByContent(String content) { return postRepository.findByContent(content); }
}
