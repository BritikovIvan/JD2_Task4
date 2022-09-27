package by.itacademy.model.repository.impl;

import by.itacademy.model.entity.Login;
import by.itacademy.model.repository.LoginRepository;

public class LoginRepositoryImpl extends DefaultRepositoryImpl<Login> implements LoginRepository {
    public LoginRepositoryImpl() {
        super(Login.class);
    }
}
