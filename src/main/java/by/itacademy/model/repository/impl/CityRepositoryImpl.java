package by.itacademy.model.repository.impl;

import by.itacademy.model.entity.City;
import by.itacademy.model.repository.CityRepository;

public class CityRepositoryImpl extends DefaultRepositoryImpl<City> implements CityRepository {
    public CityRepositoryImpl() {
        super(City.class);
    }
}
