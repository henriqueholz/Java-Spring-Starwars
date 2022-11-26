package org.starwars.api.useCases.Starship;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.starwars.api.entities.Starship.Starship;
import org.starwars.api.repository.StarshipRepository;

@Service
@Transactional
public class DecrementUnitByName {
    private final StarshipRepository starshipRepository;

    public DecrementUnitByName(StarshipRepository starshipRepository) {
        this.starshipRepository = starshipRepository;
    }

    public Starship update(String name, int unit) {
        Starship starship = starshipRepository.findByName(name);
        if (starship == null) {
            // not found
        }
        int currentUnit = starship.getCount();
        if (currentUnit < unit) {
            // error
        }
        starship.setCount(currentUnit - unit);
        starshipRepository.save(starship);
        return starship;
    }
}
