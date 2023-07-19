package com.example.instagram.api.Repository;

import com.example.instagram.api.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
