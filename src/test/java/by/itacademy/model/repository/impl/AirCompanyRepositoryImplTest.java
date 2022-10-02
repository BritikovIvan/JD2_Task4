package by.itacademy.model.repository.impl;

import by.itacademy.model.entity.AirCompany;
import by.itacademy.model.repository.AirCompanyRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class AirCompanyRepositoryImplTest {
    private static final AirCompanyRepository airCompanyRepository = new AirCompanyRepositoryImpl();

    private static List<AirCompany> companiesBeforeTest;

    @BeforeAll
    static void setCompaniesBeforeTest() {
        companiesBeforeTest = airCompanyRepository.findAll();
    }

    @Test
    void testCreate() {
        AirCompany airCompany = new AirCompany();
        airCompany.setName("Belavia");
        airCompanyRepository.save(airCompany);
        Assertions.assertNotNull(airCompany.getId());
    }

    @Test
    void testGetById() {
        AirCompany company = new AirCompany();
        company.setName("S7 Airlines");
        airCompanyRepository.save(company);
        Optional<AirCompany> airCompany = airCompanyRepository.findById(company.getId());
        if(airCompany.isPresent()) {
            Assertions.assertEquals("S7 Airlines", airCompany.get().getName());
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

    @Test
    void testGetAll() {
        List<AirCompany> airCompanyList = airCompanyRepository.findAll();

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
    }

    @AfterAll
    static void cleanDb() {
        List<AirCompany> companiesAfterTest = airCompanyRepository.findAll();
        companiesAfterTest.removeAll(companiesBeforeTest);
        companiesAfterTest.forEach(companyToDelete -> airCompanyRepository.delete(companyToDelete.getId()));
    }
}
