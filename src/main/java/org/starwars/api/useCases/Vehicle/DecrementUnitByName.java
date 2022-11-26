package org.starwars.api.useCases.Vehicle;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.starwars.api.entities.Vehicle;
import org.starwars.api.repository.VehicleRepository;

@Service
@Transactional
public class DecrementUnitByName {
    private final VehicleRepository vehicleRepository;

    public DecrementUnitByName(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle update(String name, int unit) {
        Vehicle vehicle = vehicleRepository.findByName(name);
        if (vehicle == null) {
            return null;
        }
        int currentUnit = vehicle.getCount();
        if (currentUnit < unit) {
            return null;
        }
        vehicle.setCount(currentUnit - unit);
        vehicleRepository.save(vehicle);
        return vehicle;
    }
}
