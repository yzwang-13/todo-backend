package com.wilsonwang.projects.todo.backend;

import org.springframework.web.bind.annotation.*;

// Controller
@RestController
public class HelloWorldController {

    // GET
    // URI - /hello-world
    // method - hello world

//    @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "hello world";
    }

    // hello-world-bean
    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("hello world");
    }

    // path variable and request variable
    // http://localhost:8080/hello-world-bean/ww/name/?id=100&nick=shawn
    @GetMapping(path = "/hello-world-bean/ww/{pathName}")
    public HelloWorldBean helloWorldPathVariable(
            // name defined for RequestParam has to match the request parameter name in the url
            // otherwise will throw an error
            // for path variable, you can name whatever you want
            @PathVariable  String pathName,
            @RequestParam String id,
            @RequestParam String nick
            ) {
        return new HelloWorldBean("hello world " + pathName + id + nick);
    }
}
