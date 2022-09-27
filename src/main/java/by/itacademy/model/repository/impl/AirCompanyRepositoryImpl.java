package by.itacademy.model.repository.impl;

import by.itacademy.model.entity.AirCompany;
import by.itacademy.model.repository.AirCompanyRepository;

public class AirCompanyRepositoryImpl extends DefaultRepositoryImpl<AirCompany> implements AirCompanyRepository {
    public AirCompanyRepositoryImpl() {
        super(AirCompany.class);
    }
}
