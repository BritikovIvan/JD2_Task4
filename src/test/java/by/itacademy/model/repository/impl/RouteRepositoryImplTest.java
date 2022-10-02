package by.itacademy.model.repository.impl;

import by.itacademy.model.entity.*;
import by.itacademy.model.repository.RouteRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class RouteRepositoryImplTest {
    private static final RouteRepository routeRepository = new RouteRepositoryImpl();

    private static List<Route> routesBeforeTest;

    @BeforeAll
    static void setCompaniesBeforeTest() {
        routesBeforeTest = routeRepository.findAll();
    }

    @Test
    void testCreate() {
        Route route =  new Route();
        route.setArrival(LocalDateTime.of(2022, Month.SEPTEMBER, 29, 8, 0));
        route.setDeparture(LocalDateTime.of(2022, Month.SEPTEMBER, 29, 15, 26));

        City city = new City();
        city.setName("Moscow");
        Country country = new Country();
        country.setName("Russia");
        city.setCountry(country);
        List<RouteCity> routeCities = new ArrayList<>();
        RouteCity routeCity = new RouteCity();
        routeCity.setCity(city);
        routeCity.setRoute(route);
        routeCity.setSequenceOrder(1);
        city.setRouteCities(routeCities);
        RouteCityKey routeCityKey = new RouteCityKey();
        routeCityKey.setCityId(city.getId());
        routeCityKey.setRouteId(route.getId());
        routeCity.setId(routeCityKey);
        routeCities.add(routeCity);

        city = new City();
        city.setName("Washington");
        country =new Country();
        country.setName("USA");
        city.setCountry(country);
        routeCity = new RouteCity();
        routeCity.setCity(city);
        routeCity.setRoute(route);
        routeCity.setSequenceOrder(2);
        city.setRouteCities(routeCities);
        routeCities.add(routeCity);
        routeCityKey = new RouteCityKey();
        routeCityKey.setCityId(city.getId());
        routeCityKey.setRouteId(route.getId());
        routeCity.setId(routeCityKey);
        route.setRouteCities(routeCities);

        routeRepository.save(route);
        Assertions.assertNotNull(route.getId());
    }

    @AfterAll
    static void cleanDb() {
        List<Route> routesAfterTest = routeRepository.findAll();
        routesAfterTest.removeAll(routesBeforeTest);
        routesAfterTest.forEach(companyToDelete -> routeRepository.delete(companyToDelete.getId()));
    }
}
