package org.lifung.services;

import org.lifung.MockDatabaseRepository;
import org.lifung.models.ToDoItem;
import org.lifung.models.TodoListResponse;
import org.lifung.models.TodoRequest;
import org.lifung.models.TodoUpdateRequest;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private final MockDatabaseRepository repository;

    public TodoService(MockDatabaseRepository repository) {
        this.repository = repository;
    }

    public ToDoItem addTodo(TodoRequest request, Long id) {
        return repository.addNewTodoItem(request, id);
    }
    public ToDoItem updateUpdate(TodoUpdateRequest request, Long userId, Long id) {
        return repository.updateToDo(request, userId, id);
    }
    public TodoListResponse getTodoListByUserId(Long id) {
        return new TodoListResponse(repository.getTodoListOfUserId(id));
    }
}
