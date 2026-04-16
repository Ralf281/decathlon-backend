package ee.ralf.decathlon_backend.service;

import ee.ralf.decathlon_backend.entity.Athlete;
import ee.ralf.decathlon_backend.repository.AthleteRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class AthleteService {

    private final AthleteRepository repository;

    public AthleteService(AthleteRepository repository) {
        this.repository = repository;
    }

    // 🔥 SEE ON PUUDUV MEETOD (controller kasutab seda)
    public Page<Athlete> getAthletes(String country, Pageable pageable) {

        if (country != null && !country.isEmpty()) {
            return repository.findByCountry(country, pageable);
        }

        return repository.findAll(pageable);
    }

    public Athlete save(Athlete athlete) {
        return repository.save(athlete);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}