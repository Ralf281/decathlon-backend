package ee.ralf.decathlon_backend.entity;

import jakarta.persistence.*;
import ee.ralf.decathlon_backend.entity.Athlete;

@Entity
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int points;
    private String sport;

    @ManyToOne
    @JoinColumn(name = "athlete_id")
    private Athlete athlete;
}
