package org.starwars.api.useCases.Starship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.starwars.api.entities.Starship;
import org.starwars.api.repository.StarshipRepository;

@Service("DecrementStarshipUnitByName")
@Transactional
public class DecrementUnitByName {
    @Autowired
    private final StarshipRepository starshipRepository;

    public DecrementUnitByName(StarshipRepository starshipRepository) {
        this.starshipRepository = starshipRepository;
    }

    public Starship update(String name, int unit) {
        Starship starship = starshipRepository.findByName(name);
        if (starship == null) {
            return null;
        }
        int currentUnit = starship.getCount();
        if (currentUnit < unit) {
            return null;
        }
        starship.setCount(currentUnit - unit);
        starshipRepository.save(starship);
        return starship;
    }
}
