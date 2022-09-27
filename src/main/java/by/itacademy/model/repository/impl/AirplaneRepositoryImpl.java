package by.itacademy.model.repository.impl;

import by.itacademy.model.entity.Airplane;
import by.itacademy.model.repository.AirplaneRepository;

public class AirplaneRepositoryImpl extends DefaultRepositoryImpl<Airplane> implements AirplaneRepository {

    public AirplaneRepositoryImpl() {
        super(Airplane.class);
    }
}
