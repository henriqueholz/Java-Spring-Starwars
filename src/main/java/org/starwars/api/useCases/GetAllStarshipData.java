package org.starwars.api.useCases;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.starwars.api.entities.GetAllStarshipDataResponse;
import org.starwars.api.entities.Starship;
import org.starwars.api.repository.StarshipRepository;
import org.yaml.snakeyaml.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

@Service
@Transactional
public class GetAllStarshipData {
    private final StarshipRepository starshipRepository;

    public GetAllStarshipData(StarshipRepository starshipRepository) {
        this.starshipRepository = starshipRepository;
    }

    public List<Starship> getAll() {
        String getAllStarshipUri = "https://swapi.dev/api/starships/";
        RestTemplate restTemplate = new RestTemplate();
        List<Starship> starshipList = new ArrayList<>();
        do {
            GetAllStarshipDataResponse getAllStarshipDataResponse = restTemplate.getForObject(getAllStarshipUri, GetAllStarshipDataResponse.class);
            starshipList.addAll(Arrays.asList(getAllStarshipDataResponse.getResults()));
            getAllStarshipUri = getAllStarshipDataResponse.getNext();

        } while (getAllStarshipUri != null);
        return starshipRepository.findAll();
    }
}
