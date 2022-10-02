package by.itacademy.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private LocalDateTime arrival;
    @Column
    private LocalDateTime departure;
    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL)
    private List<RouteCity> routeCities;
}
