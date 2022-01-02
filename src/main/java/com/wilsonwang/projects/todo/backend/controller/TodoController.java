package com.wilsonwang.projects.todo.backend.controller;

import com.sun.xml.bind.v2.TODO;
import com.wilsonwang.projects.todo.backend.model.Todo;
import com.wilsonwang.projects.todo.backend.service.TodoHardcodedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
//        System.out.println(todoService.getTodos());
        return todoService.getTodos();
    }

    @RequestMapping(value = "/todos/{username}/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable String id) {
        Todo todo = todoService.deleteTodo(id);
        if (todo != null) {
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/todos/{username}/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable String id , @RequestBody Todo todo) {
        System.out.println(todo.toString());
        System.out.println(id);
        System.out.println(todo.getId());
        if (!id.equals(todo.getId())){
//            return ResponseEntity.badRequest().build();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }else {
            Todo updatedTodo = todoService.updateTodo(id, todo);
            if (updatedTodo == null ) {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//                return ResponseEntity.notFound().build();
            }else {
                return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
            }
        }
    };

    @RequestMapping(value = "/todos/{username}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Todo> addTodo(@PathVariable String username , @RequestBody Todo todo) {
        System.out.println(todo.toString());

//        TODO: add id
        Todo createdTodo =  todoService.createTodo(todo);
            if (createdTodo == null ) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }else {
                return new ResponseEntity<>(createdTodo, HttpStatus.OK);
            }

    };
}
