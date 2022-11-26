package org.starwars.api.useCases;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.starwars.api.entities.GetAllStarshipDataResponse;
import org.starwars.api.entities.Starship;
import org.starwars.api.repository.StarshipRepository;

import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class GetAllStarshipData {
    private final StarshipRepository starshipRepository;

    public GetAllStarshipData(StarshipRepository starshipRepository) {
        this.starshipRepository = starshipRepository;
    }

    public List<Starship> getAll() {
        List<Starship> starshipList = starshipRepository.findAll();
        if (starshipList.size() == 0) {
            String getAllStarshipUri = "https://swapi.dev/api/starships/";
            RestTemplate restTemplate = new RestTemplate();
            do {
                GetAllStarshipDataResponse getAllStarshipDataResponse = restTemplate.getForObject(getAllStarshipUri, GetAllStarshipDataResponse.class);
                starshipList.addAll(Arrays.asList(getAllStarshipDataResponse.getResults()));
                getAllStarshipUri = getAllStarshipDataResponse.getNext();

            } while (getAllStarshipUri != null);
            starshipRepository.insert(starshipList);
        }
        return starshipList;
    }
}
