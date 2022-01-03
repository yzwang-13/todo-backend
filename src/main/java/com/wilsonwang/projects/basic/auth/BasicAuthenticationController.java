package com.wilsonwang.projects.basic.auth;

import org.springframework.web.bind.annotation.*;

// Controller
@RestController
@CrossOrigin(origins = "*")
public class BasicAuthenticationController {

    // basicauth bean
    @GetMapping(path = "/basicauth")
    public AuthenticationBean helloWorldBean() {
        return new AuthenticationBean("You are authenticated");
    }

}
