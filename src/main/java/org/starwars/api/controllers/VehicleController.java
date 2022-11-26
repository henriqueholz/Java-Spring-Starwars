package org.starwars.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.starwars.api.entities.UnitCountResponse;
import org.starwars.api.entities.Vehicle;
import org.starwars.api.useCases.Vehicle.DecrementUnitByName3;
import org.starwars.api.useCases.Vehicle.GetUnitByName;
import org.starwars.api.useCases.Vehicle.IncrementUnitByName;
import org.starwars.api.useCases.Vehicle.SetUnitByName;

import java.util.Optional;

@RestController
public class VehicleController {
    private final GetUnitByName getUnitByName;
    private final SetUnitByName setUnitByName;
    private final IncrementUnitByName incrementUnitByName;
    private final DecrementUnitByName3 decrementUnitByName;

    public VehicleController(GetUnitByName getUnitByName, SetUnitByName setUnitByName, IncrementUnitByName incrementUnitByName, DecrementUnitByName3 decrementUnitByName) {
        this.getUnitByName = getUnitByName;
        this.setUnitByName = setUnitByName;
        this.incrementUnitByName = incrementUnitByName;
        this.decrementUnitByName = decrementUnitByName;
    }

    @GetMapping(value = "/vehicle/{name}")
    public ResponseEntity<UnitCountResponse> getByName(@PathVariable String name) {
        return ToResponseEntity(Optional.ofNullable(getUnitByName.get(name)));
    }

    @PutMapping(value = "/vehicle/{name}/set-unit/{unit}")
    public ResponseEntity<UnitCountResponse> setUnitByName(@PathVariable String name, @PathVariable int unit) {
        return ToResponseEntity(Optional.ofNullable(setUnitByName.update(name, unit)));
    }

    @PutMapping(value = "/vehicle/{name}/increment-unit/{unit}")
    public ResponseEntity<UnitCountResponse> incrementUnitByName(@PathVariable String name, @PathVariable int unit) {
        return ToResponseEntity(Optional.ofNullable(incrementUnitByName.update(name, unit)));
    }

    @PutMapping(value = "/vehicle/{name}/decrement-unit/{unit}")
    public ResponseEntity<UnitCountResponse> decrementUnitByName(@PathVariable String name, @PathVariable int unit) {
        return ToResponseEntity(Optional.ofNullable(decrementUnitByName.update(name, unit)));
    }

    public ResponseEntity<UnitCountResponse> ToResponseEntity(Optional<Vehicle> vehicle) {
        if (vehicle.isPresent()) {
            UnitCountResponse unitCountResponse = new UnitCountResponse(vehicle.get().getId(), vehicle.get().getName(), vehicle.get().getCount());
            return new ResponseEntity<>(unitCountResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
