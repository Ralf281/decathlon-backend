package ee.ralf.decathlon_backend.controller;

import ee.ralf.decathlon_backend.entity.Athlete;
import ee.ralf.decathlon_backend.service.AthleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/athletes")
@RequiredArgsConstructor
@CrossOrigin
public class AthleteController {

    private final AthleteService service;

    @GetMapping
    public Page<Athlete> getAll(
            @RequestParam(required = false) String country,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "points") String sortBy,
            @RequestParam(defaultValue = "desc") String order
    ) {

        Sort sort = order.equalsIgnoreCase("asc")
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sort);

        return service.getAthletes(country, pageable);
    }

    @PostMapping
    public Athlete add(@RequestBody Athlete athlete) {
        return service.save(athlete);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
