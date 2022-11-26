package org.starwars.api.useCases.Starship;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.starwars.api.entities.Starship;
import org.starwars.api.repository.StarshipRepository;

@Service("SetStarshipUnitByName")
@Transactional
public class SetUnitByName {
    private final StarshipRepository starshipRepository;

    public SetUnitByName(StarshipRepository starshipRepository) {
        this.starshipRepository = starshipRepository;
    }

    public Starship update(String name, int unit) {
        Starship starship = starshipRepository.findByName(name);
        if (starship == null) {
            return null;
        }
        starship.setCount(unit);
        starshipRepository.save(starship);

        return starship;
    }
}
