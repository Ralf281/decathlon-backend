package ee.ralf.decathlon_backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import ee.ralf.decathlon_backend.entity.Result;

import java.util.List;

@Data
@Entity
public class Athlete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String country;

    private int points;

    @OneToMany(mappedBy = "athlete")
    private List<Result> results;
}
