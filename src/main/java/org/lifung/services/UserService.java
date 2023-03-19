package org.lifung.services;

import org.lifung.MockDatabaseRepository;
import org.lifung.models.User;
import org.lifung.models.UserRequest;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final MockDatabaseRepository repository;

    public UserService(MockDatabaseRepository repository) {
        this.repository = repository;
    }

    public User createNewUser(UserRequest request) {

        return repository.createNewUser(request);
    }
}
