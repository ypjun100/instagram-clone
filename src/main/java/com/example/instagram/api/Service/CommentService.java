package com.example.instagram.api.Service;

import com.example.instagram.api.Entity.Comment;
import com.example.instagram.api.Entity.Post;
import com.example.instagram.api.Entity.User;
import com.example.instagram.api.Repository.CommentRepository;
import com.example.instagram.api.Repository.PostRepository;
import com.example.instagram.api.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public List<Comment> findCommentsByPostId(long post_id) {
        return commentRepository.findCommentsByPostId(post_id);
    }

    @Transactional
    public Boolean write(String user_id, String content, long post_id) {
        Optional<User> _user = userRepository.findById(user_id);
        Optional<Post> _post = postRepository.findById(post_id);

        if (!_user.isEmpty() && !_post.isEmpty()) {
            Comment newComment = new Comment();
            newComment.setUser(_user.get());
            newComment.setContent(content);
            newComment.setPost(_post.get());
            commentRepository.save(newComment);

            _post.get().setCommentCount(_post.get().getCommentCount() + 1);

            return true;
        }
        return false;
    }

    @Transactional
    public boolean update(long id, String content) {
        Optional<Comment> _comment = commentRepository.findById(id);

        if (!_comment.isEmpty()) {
            _comment.get().setContent(content);
            return true;
        }
        return false;
    }

    @Transactional
    public boolean delete(long id) {
        if (commentRepository.existsById(id)) {
            Optional<Comment> _comment = commentRepository.findById(id);
            _comment.get().getPost().setCommentCount(_comment.get().getPost().getCommentCount() - 1);
            commentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
