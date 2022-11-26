package org.starwars.api.useCases.Starship;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.starwars.api.entities.Starship;
import org.starwars.api.repository.StarshipRepository;

@Service
@Transactional
public class IncrementUnitByName {
    private final StarshipRepository starshipRepository;

    public IncrementUnitByName(StarshipRepository starshipRepository) {
        this.starshipRepository = starshipRepository;
    }

    public Starship update(String name, int unit) {
        Starship starship = starshipRepository.findByName(name);
        if (starship == null) {
            // not found
        }
        starship.setCount(starship.getCount() + unit);
        starshipRepository.save(starship);
        return starship;
    }
}
