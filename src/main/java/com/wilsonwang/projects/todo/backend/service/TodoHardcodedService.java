package com.wilsonwang.projects.todo.backend.service;

import com.wilsonwang.projects.todo.backend.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoHardcodedService {

    private static List<Todo> todos = new ArrayList();
    private static int counter = 0;

    static {
        todos.add(new Todo("wilson", 123,new Date(2021, 11, 11), "Cook", false));
        todos.add(new Todo("evelyn",234, new Date(2021, 12, 11), "Go to Coles", false));
        todos.add(new Todo("aaa", 345, new Date(2014, 10, 11), "Learn java", false));
    }
    public  List<Todo> getTodos() {
        return todos;
    }

    public  Todo deleteTodo(long id) {
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

    private Todo findById(long id) {
        for (Todo todo: todos) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }


}
