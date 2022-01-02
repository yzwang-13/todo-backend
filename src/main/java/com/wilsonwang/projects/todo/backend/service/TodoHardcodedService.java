package com.wilsonwang.projects.todo.backend.service;

import com.wilsonwang.projects.todo.backend.model.Todo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class TodoHardcodedService {

    private static List<Todo> todos = new ArrayList();
    private static int counter = 0;

    static {
        todos.add(new Todo("wilson", "123", LocalDate.of(2014, 2, 14), "Cook", false));
        todos.add(new Todo("evelyn","234", LocalDate.of(2014, 2, 14), "Go to Coles", false));
        todos.add(new Todo("aaa", "345", LocalDate.of(2014, 2, 14), "Learn java", false));
    }
    public  List<Todo> getTodos() {
        return todos;
    }



    public  Todo deleteTodo(String id) {
        Todo todo = findById(id);
        if (todo == null) {
            return null;
        }
        if (todos.remove(todo)) {
            return todo;
        }else {
            return null;
        }
    }

    public Todo createTodo(Todo todo) {
        todo.setId(UUID.randomUUID().toString());
        todos.add(todo);
        return todo;
    }

    public Todo addTodo(Todo todo) {
        todos.add(todo);
        return todo;
    }

    public Todo updateTodo(String oldTodoId, Todo newTodo) {
        Todo oldTodo = findById(oldTodoId);
        if (oldTodo == null) {
            return null;
        }else {
            deleteTodo(oldTodoId);
            addTodo(newTodo);
            return newTodo;
        }
    }

    private Todo findById(String id) {
        for (Todo todo: todos) {
            if (todo.getId().equals(id)) {
                return todo;
            }
        }
        return null;
    }


}
