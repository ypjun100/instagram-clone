package com.example.instagram.api.Service;

import com.example.instagram.api.Entity.User;
import com.example.instagram.api.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public boolean signIn(String id, String password) {
        Optional<User> _user = userRepository.findById(id);

        if (_user.isEmpty()) return false;

        if (_user.get().getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    @Transactional
    public int enroll(String id, String password, String name) {
        // 0 - sign up success!
        // 1 - error(there is same user id)

        if (!userRepository.findById(id).isEmpty()) { return 1; }

        User newUser = new User(id, password, name);
        System.out.println(newUser.toString());
        userRepository.save(newUser);
        return 0;
    }
}
