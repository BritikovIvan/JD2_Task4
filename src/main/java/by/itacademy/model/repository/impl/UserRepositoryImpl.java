package by.itacademy.model.repository.impl;

import by.itacademy.model.entity.User;
import by.itacademy.model.repository.UserRepository;

public class UserRepositoryImpl extends DefaultRepositoryImpl<User> implements UserRepository {
    public UserRepositoryImpl() {
        super(User.class);
    }
}
