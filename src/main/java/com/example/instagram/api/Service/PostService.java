package com.example.instagram.api.Service;

import com.example.instagram.api.Entity.Post;
import com.example.instagram.api.Entity.User;
import com.example.instagram.api.Repository.PostRepository;
import com.example.instagram.api.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    private final UserService userService;
    private final UserRepository userRepository;

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
    public long write(String user_id, String photos, String description) {
        Optional<User> writer = userRepository.findById(user_id);

        if (!writer.isEmpty()) {
            Post newPost = new Post();
            newPost.setUser(writer.get());
            newPost.setPhotos(photos);
            newPost.setDescription(description);
            postRepository.save(newPost);
            return newPost.getId();
        }

        return -1;
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
