package by.itacademy.model.repository.impl;

import by.itacademy.model.entity.City;
import by.itacademy.model.entity.Country;
import by.itacademy.model.entity.Route;
import by.itacademy.model.repository.RouteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RouteRepositoryImplTest {
    private final RouteRepository routeRepository = new RouteRepositoryImpl();

    @Test
    void testCreate() {
        Route route =  new Route();
        route.setArrival(LocalDateTime.of(2022, Month.SEPTEMBER, 29, 8, 0));
        route.setDeparture(LocalDateTime.of(2022, Month.SEPTEMBER, 29, 15, 26));

        List<Route> routes = new ArrayList<>();
        routes.add(route);
        List<City> cities = new ArrayList<>();
        City city = new City();
        city.setName("Moscow");
        Country country = new Country();
        country.setName("Russia");
        city.setRoutes(routes);
        city.setCountry(country);
        cities.add(city);
        city = new City();
        city.setName("Washington");
        country =new Country();
        country.setName("USA");
        city.setRoutes(routes);
        city.setCountry(country);
        cities.add(city);

        route.setCities(cities);

        routeRepository.save(route);
        Assertions.assertNotNull(route.getId());
    }
}
