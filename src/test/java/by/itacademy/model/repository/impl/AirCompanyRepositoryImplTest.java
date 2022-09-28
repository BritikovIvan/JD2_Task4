package by.itacademy.model.repository.impl;

import by.itacademy.model.entity.AirCompany;
import by.itacademy.model.repository.AirCompanyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AirCompanyRepositoryImplTest {
    private final AirCompanyRepository airCompanyRepository = new AirCompanyRepositoryImpl();

    @Test
    void testCreate() {
        AirCompany airCompany = new AirCompany();
        airCompany.setName("Belavia");
        airCompanyRepository.save(airCompany);
        Assertions.assertNotNull(airCompany.getId());

        airCompanyRepository.delete(airCompany.getId());
    }

    @Test
    void testGetById() {
        AirCompany company = new AirCompany();
        company.setName("Belavia");
        airCompanyRepository.save(company);
        Optional<AirCompany> airCompany = airCompanyRepository.findById(company.getId());
        if(airCompany.isPresent()) {
            Assertions.assertEquals("Belavia", airCompany.get().getName());
        } else {
            Assertions.fail();
        }

        airCompanyRepository.delete(company.getId());
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

        airCompanyRepository.delete(airCompany.getId());
    }

    @Test
    void testDelete() {
        AirCompany airCompany = new AirCompany();
        airCompany.setName("Air Europa");
        airCompanyRepository.save(airCompany);
        airCompanyRepository.delete(airCompany.getId());
        Assertions.assertTrue(airCompanyRepository.findById(airCompany.getId()).isEmpty());
    }

    @Test
    void testGetAll() {
        List<AirCompany> deleteList = airCompanyRepository.findAll();

        List<AirCompany> airCompanyList = new ArrayList<>(deleteList);

        AirCompany company = new AirCompany();
        company.setName("I-Fly");
        airCompanyRepository.save(company);
        airCompanyList.add(company);
        company = new AirCompany();
        company.setName("Sky Express");
        airCompanyRepository.save(company);
        airCompanyList.add(company);

        List<AirCompany> airCompanies = airCompanyRepository.findAll();
        airCompanyList.removeAll(airCompanies);
        Assertions.assertTrue(airCompanyList.isEmpty());

        airCompanies.removeAll(deleteList);
        airCompanies.forEach(companyToDelete -> airCompanyRepository.delete(companyToDelete.getId()));
    }
}
