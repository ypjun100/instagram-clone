package com.example.instagram.api.Controller;

import com.example.instagram.api.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("sign-in")
    public String signIn(@RequestParam String id, @RequestParam String password) {
        if (userService.signIn(id, password)) {
            return "user";
        }
        return "non-user";
    }

    @PostMapping("sign-out")
    public String signOut() {
        // 로그 아웃
        return "signed out";
    }

    @PostMapping("sign-up")
    public String signUp(@RequestParam String id, @RequestParam String password, @RequestParam String name) {
        int signupResult = userService.enroll(id, password, name);

        if (signupResult == 1) {
            return "there is same user id.";
        }

        return "succeed!";
    }
}
