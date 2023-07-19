package com.example.instagram.api.Service;

import com.example.instagram.api.Entity.Post;
import com.example.instagram.api.Repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<Post> retrieveAll() {
        return postRepository.findAll();
    }

    public Post retrieve(long id) {
        Optional<Post> _post = postRepository.findById(id);
        if (!_post.isEmpty()) {
            return _post.get();
        }
        return new Post();
    }

    @Transactional
    public long write(String photos, String description) {
        Post newPost = new Post();
        newPost.setPhotos(photos);
        newPost.setDescription(description);
        postRepository.save(newPost);

        return newPost.getId();
    }

    @Transactional
    public long update(long id, String photos, String description) {
        Optional<Post> _post = postRepository.findById(id);

        if (!_post.isEmpty()) {
            _post.get().setPhotos(photos);
            _post.get().setDescription(description);
            return _post.get().getId();
        }
        return -1;
    }

    @Transactional
    public Boolean delete(long id) {
        if (postRepository.existsById(id)) {
            postRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
