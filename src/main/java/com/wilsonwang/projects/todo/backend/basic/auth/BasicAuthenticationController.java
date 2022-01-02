package com.wilsonwang.projects.todo.backend.basic.auth;

import org.springframework.web.bind.annotation.*;

// Controller
@RestController
@CrossOrigin(origins = "*")
public class BasicAuthenticationController {

    // hello-world-bean
    @GetMapping(path = "/hello-world-bean")
    public AuthenticationBean helloWorldBean() {
        return new AuthenticationBean("You are authenticated");
    }

}
