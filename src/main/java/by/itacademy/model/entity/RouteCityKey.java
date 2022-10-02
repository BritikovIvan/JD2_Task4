package by.itacademy.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class RouteCityKey implements Serializable {
    @Column(name = "route_id")
    Long routeId;
    @Column(name = "city_id")
    Long cityId;
}
