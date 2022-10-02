package by.itacademy.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "route_city")
public class RouteCity {
    @EmbeddedId
    RouteCityKey id;
    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("routeId")
    @JoinColumn(name = "route_id")
    Route route;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("cityId")
    @JoinColumn(name = "city_id")
    City city;

    @Column(name = "sequence_order")
    Integer sequenceOrder;
}
