package by.itacademy.model.repository.impl;

import by.itacademy.model.entity.Route;
import by.itacademy.model.repository.RouteRepository;

public class RouteRepositoryImpl extends DefaultRepositoryImpl<Route> implements RouteRepository {
    public RouteRepositoryImpl() {
        super(Route.class);
    }
}
