package org.starwars.api.useCases;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.starwars.api.entities.Starship;
import org.starwars.api.repository.StarshipRepository;

import java.util.List;

@Service
@Transactional
public class GetAllStarshipData {
    private final StarshipRepository starshipRepository;

    public GetAllStarshipData(StarshipRepository starshipRepository) {
        this.starshipRepository = starshipRepository;
    }

    public List<Starship> getAll() {
        return starshipRepository.findAll();
    }
}
