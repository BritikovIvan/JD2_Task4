package by.itacademy.model.repository.impl;

import by.itacademy.model.entity.Country;
import by.itacademy.model.repository.CountryRepository;

public class CountryRepositoryImpl extends DefaultRepositoryImpl<Country> implements CountryRepository {
    public CountryRepositoryImpl() {
        super(Country.class);
    }
}
