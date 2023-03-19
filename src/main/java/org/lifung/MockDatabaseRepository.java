package org.lifung;

import org.lifung.exceptions.TodoException;
import org.lifung.models.Status;
import org.lifung.models.ToDoItem;
import org.lifung.models.TodoRequest;
import org.lifung.models.TodoUpdateRequest;
import org.lifung.models.User;
import org.lifung.models.UserRequest;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class MockDatabaseRepository {

    private Map<Long, Map<Long, ToDoItem>> todoRepo = new HashMap<>();

    private static Long todoAutoGenerateId = 1L;
    private static Long userAutoGenerateId = 1L;

    public MockDatabaseRepository() {
        todoRepo.put(userAutoGenerateId, new HashMap<>());
        userAutoGenerateId++;
    }

    public User createNewUser(UserRequest request) {
        User user = new User();
        user.setId(userAutoGenerateId);
        userAutoGenerateId++;
        user.setName(request.getName());
        todoRepo.put(user.getId(), new HashMap<>());
        return user;
    }
    public ToDoItem addNewTodoItem(TodoRequest request, Long userId) {
        if (!todoRepo.containsKey(userId)) {
            throw new TodoException("User is not found");
        }
        ToDoItem item = new ToDoItem();
        item.setContent(request.getContent());
        item.setNote(request.getNote());
        item.setPriority(request.getPriority());
        item.setStatus(Status.TODO);
        item.setOwnerId(userId);
        item.setTitle(request.getTitle());
        item.setId(todoAutoGenerateId);
        todoAutoGenerateId++;
        todoRepo.get(userId).put(item.getId(), item);
        return item;
    }
    public ToDoItem getTodoItemOfUserId(Long userId, Long id) {
        if (!todoRepo.containsKey(userId)) {
            throw new TodoException("User is not found");
        }
        Map<Long, ToDoItem> todoMap = todoRepo.get(userId);
        if (!todoMap.containsKey(id)) {
            throw new TodoException("Todo is not found");
        }
        return todoMap.get(id);
    }

    public ToDoItem updateToDo(TodoUpdateRequest request, Long userId, Long id) {
        ToDoItem item = getTodoItemOfUserId(userId, id);
        if (request.getContent() != null && !request.getContent().equals("")) {
            item.setContent(request.getContent());
        }
        if (request.getNote() != null && !request.getNote().equals("")) {
            item.setNote(request.getNote());
        }
        if (request.getPriority() != null) {
            item.setPriority(request.getPriority());
        }
        if (request.getTitle() != null && !request.getTitle().equals("")) {
            item.setTitle(request.getTitle());
        }
        if (request.getStatus() != null) {
            item.setStatus(request.getStatus());
        }
        todoRepo.get(userId).put(id, item);
        return item;
    }
    public List<ToDoItem> getTodoListOfUserId(Long userId) {
        if (!todoRepo.containsKey(userId)) {
            throw new TodoException("User is not found");
        }
        Map<Long, ToDoItem> todoMap = todoRepo.get(userId);
        return todoMap.values().stream().collect(Collectors.toList());
    }
}
