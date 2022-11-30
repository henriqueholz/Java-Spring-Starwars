package org.starwars.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.starwars.api.entities.GetAllStarshipDataResponse;
import org.starwars.api.entities.GetAllVehicleDataResponse;
import org.starwars.api.entities.Starship;
import org.starwars.api.entities.Vehicle;
import org.starwars.api.repository.StarshipRepository;
import org.starwars.api.repository.VehicleRepository;

import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private StarshipRepository starshipRepository;
    private VehicleRepository vehicleRepository;

    @Autowired
    public DataLoader(StarshipRepository starshipRepository, VehicleRepository vehicleRepository) {
        this.starshipRepository = starshipRepository;
        this.vehicleRepository = vehicleRepository;
    }

    public void run(ApplicationArguments args) {
        int id = 0;
        List<Starship> starshipList = starshipRepository.findAll();
        if (starshipList.size() == 0) {
            String getAllStarshipUri = "https://swapi.dev/api/starships/";
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

        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if (vehicleList.size() == 0) {
            String getAllVehicleUri = "https://swapi.dev/api/vehicles/";
            RestTemplate restTemplate = new RestTemplate();
            do {
                GetAllVehicleDataResponse getAllVehicleDataResponse = restTemplate.getForObject(getAllVehicleUri, GetAllVehicleDataResponse.class);
                for (Vehicle vehicle : getAllVehicleDataResponse.getResults()) {
                    vehicle.setId(id);
                    id++;
                }
                vehicleList.addAll(Arrays.asList(getAllVehicleDataResponse.getResults()));
                getAllVehicleUri = getAllVehicleDataResponse.getNext();

            } while (getAllVehicleUri != null);
            vehicleRepository.insert(vehicleList);
        }
    }
}