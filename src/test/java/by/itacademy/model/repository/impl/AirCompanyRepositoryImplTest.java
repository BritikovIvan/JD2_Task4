package by.itacademy.model.repository.impl;

import by.itacademy.model.entity.AirCompany;
import by.itacademy.model.repository.AirCompanyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AirCompanyRepositoryImplTest {
    private final AirCompanyRepository airCompanyRepository = new AirCompanyRepositoryImpl();

    @Test
    void createAirCompany() {
        AirCompany airCompany = new AirCompany();
        airCompany.setName("Belavia");
        airCompanyRepository.save(airCompany);
        Assertions.assertNotNull(airCompany.getId());
    }
}
