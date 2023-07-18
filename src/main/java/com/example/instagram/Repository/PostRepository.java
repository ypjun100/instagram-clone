package com.example.instagram.Repository;

import com.example.instagram.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post findByContent(String content);
}
