package org.starwars.api.useCases.Starship;

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
public class GetAll {
    private final StarshipRepository starshipRepository;

    public GetAll(StarshipRepository starshipRepository) {
        this.starshipRepository = starshipRepository;
    }

    public List<Starship> get() {
        List<Starship> starshipList = starshipRepository.findAll();
        if (starshipList.size() == 0) {
            String getAllStarshipUri = "https://swapi.dev/api/starships/";
            int id = 0;
            RestTemplate restTemplate = new RestTemplate();
            do {
                GetAllStarshipDataResponse getAllStarshipDataResponse = restTemplate.getForObject(getAllStarshipUri, GetAllStarshipDataResponse.class);
                for (Starship starship : getAllStarshipDataResponse.getResults()) {
                    starship.setId(id);
                    id++;
                }
                starshipList.addAll(Arrays.asList(getAllStarshipDataResponse.getResults()));
                getAllStarshipUri = getAllStarshipDataResponse.getNext();

            } while (getAllStarshipUri != null);
            starshipRepository.insert(starshipList);
        }
        return starshipList;
    }
}
