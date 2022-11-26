package org.starwars.api.useCases;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.starwars.api.entities.GetAllVehicleDataResponse;
import org.starwars.api.entities.Vehicle;
import org.starwars.api.repository.VehicleRepository;

import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class GetAllVehicleData {
    private final VehicleRepository vehicleRepository;

    public GetAllVehicleData(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> getAll() {
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if (vehicleList.size() == 0) {
            String getAllVehicleUri = "https://swapi.dev/api/vehicles/";
            RestTemplate restTemplate = new RestTemplate();
            do {
                GetAllVehicleDataResponse getAllVehicleDataResponse = restTemplate.getForObject(getAllVehicleUri, GetAllVehicleDataResponse.class);
                vehicleList.addAll(Arrays.asList(getAllVehicleDataResponse.getResults()));
                getAllVehicleUri = getAllVehicleDataResponse.getNext();

            } while (getAllVehicleUri != null);
            vehicleRepository.insert(vehicleList);
        }
        return vehicleList;
    }
}
