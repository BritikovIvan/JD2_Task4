package by.itacademy.model.repository.impl;

import by.itacademy.model.entity.AirCompany;
import by.itacademy.model.repository.AirCompanyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class AirCompanyRepositoryImplTest {
    private final AirCompanyRepository airCompanyRepository = new AirCompanyRepositoryImpl();

    @Test
    void testCreate() {
        AirCompany airCompany = new AirCompany();
        airCompany.setName("Belavia");
        airCompanyRepository.save(airCompany);
        Assertions.assertNotNull(airCompany.getId());
    }

    @Test
    void testGetById() {
        Optional<AirCompany> airCompany = airCompanyRepository.findById(1L);
        if(airCompany.isPresent()) {
            Assertions.assertEquals("Belavia", airCompany.get().getName());
        } else {
            Assertions.fail();
        }
    }

    @Test
    void testUpdate() {
        AirCompany airCompany = new AirCompany();
        airCompany.setName("Turkish Airlines");
        airCompanyRepository.save(airCompany);
        airCompany.setName("Ryanair");
        airCompanyRepository.update(airCompany);
        Optional<AirCompany> company = airCompanyRepository.findById(airCompany.getId());
        company.ifPresent(value -> Assertions.assertEquals(airCompany, value));
    }

    @Test
    void testDelete() {
        AirCompany airCompany = new AirCompany();
        airCompany.setName("Air Europa");
        airCompanyRepository.save(airCompany);
        airCompanyRepository.delete(airCompany.getId());
        Assertions.assertTrue(airCompanyRepository.findById(airCompany.getId()).isEmpty());
    }
}
