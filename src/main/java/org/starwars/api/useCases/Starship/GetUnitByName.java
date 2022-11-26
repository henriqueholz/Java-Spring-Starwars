package org.starwars.api.useCases.Starship;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.starwars.api.entities.Starship.Starship;
import org.starwars.api.repository.StarshipRepository;

@Service
@Transactional
public class GetUnitByName {
    private final StarshipRepository starshipRepository;

    public GetUnitByName(StarshipRepository starshipRepository) {
        this.starshipRepository = starshipRepository;
    }

    public Starship get(String name) {
        Starship starship = starshipRepository.findByName(name);
        if (starship == null) {
            // error
        }
        return starship;
    }
}
