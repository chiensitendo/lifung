package org.lifung.controller;

import org.lifung.models.TodoUpdateRequest;
import org.lifung.models.User;
import org.lifung.services.TodoService;
import org.lifung.models.ToDoItem;
import org.lifung.models.TodoListResponse;
import org.lifung.models.TodoRequest;
import org.lifung.models.UserRequest;
import org.lifung.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    private final TodoService todoService;
    private final UserService userService;

    public TodoController(TodoService todoService, UserService userService) {
        this.todoService = todoService;
        this.userService = userService;
    }

    @PostMapping("user/{userId}/todo")
    public ResponseEntity<ToDoItem> createTodo(@PathVariable("userId") Long userId, @RequestBody TodoRequest request) {

        return ResponseEntity.ok(todoService.addTodo(request,userId));
    }
    @PutMapping("user/{userId}/todo/{id}")
    public ResponseEntity<ToDoItem> createTodo(@PathVariable("userId") Long userId, @PathVariable("id") Long id, @RequestBody TodoUpdateRequest request) {

        return ResponseEntity.ok(todoService.updateUpdate(request, userId, id));
    }
    @PostMapping("user")
    public ResponseEntity<User> createNewUser(@RequestBody UserRequest request) {

        return ResponseEntity.ok(userService.createNewUser(request));
    }

    @GetMapping("user/{userId}/todo")
    public ResponseEntity<TodoListResponse> getTodoList(@PathVariable("userId") Long userId) {

        return ResponseEntity.ok(todoService.getTodoListByUserId(userId));
    }

}
