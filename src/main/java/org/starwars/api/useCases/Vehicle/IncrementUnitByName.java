package org.starwars.api.useCases.Vehicle;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.starwars.api.entities.Vehicle;
import org.starwars.api.repository.VehicleRepository;

@Service
@Transactional
public class IncrementUnitByName {
    private final VehicleRepository vehicleRepository;

    public IncrementUnitByName(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle update(String name, int unit) {
        Vehicle vehicle = vehicleRepository.findByName(name);
        if (vehicle == null) {
            return null;
        }
        vehicle.setCount(vehicle.getCount() + unit);
        return vehicleRepository.save(vehicle);
    }
}
