package com.wilsonwang.projects.todo.backend.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Todo {
    private String id;
    private String username;
    private LocalDate targetDate;
    private String description;
    private Boolean done;

    public Todo(String username, String id, LocalDate targetDate, String description, Boolean done) {
        this.username = username;
        this.id = id;
        this.targetDate = targetDate;
        this.description = description;
        this.done = done;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return id == todo.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", targetDate=" + targetDate +
                ", description='" + description + '\'' +
                ", done=" + done +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}
