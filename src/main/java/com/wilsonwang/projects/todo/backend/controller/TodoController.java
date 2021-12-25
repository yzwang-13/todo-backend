package com.wilsonwang.projects.todo.backend.controller;

import com.wilsonwang.projects.todo.backend.model.Todo;
import com.wilsonwang.projects.todo.backend.service.TodoHardcodedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class TodoController {
    List<Todo> list = new ArrayList<Todo>();

    @Autowired
    private TodoHardcodedService todoService;

    @RequestMapping(value = "/todos/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Todo> getAllTodos(@PathVariable  String username) {
//        TodoHardcodedService.getTodos();
        System.out.println(todoService.getTodos());
        return todoService.getTodos();
    }

    @RequestMapping(value = "/todos/{username}/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable Long id) {
        Todo todo = todoService.deleteTodo(id);
        if (todo != null) {
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
