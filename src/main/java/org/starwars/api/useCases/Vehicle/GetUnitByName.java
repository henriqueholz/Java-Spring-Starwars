package org.starwars.api.useCases.Vehicle;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.starwars.api.entities.Vehicle;
import org.starwars.api.repository.VehicleRepository;

@Service
@Transactional
public class GetUnitByName {
    private final VehicleRepository vehicleRepository;

    public GetUnitByName(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle get(String name) {
        Vehicle vehicle = vehicleRepository.findByName(name);
        if (vehicle == null) {
            return null;
        }
        return vehicle;
    }
}
