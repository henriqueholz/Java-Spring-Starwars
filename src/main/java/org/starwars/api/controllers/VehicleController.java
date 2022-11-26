package org.starwars.api.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.starwars.api.entities.Vehicle;
import org.starwars.api.useCases.GetAllVehicleData;

import java.util.List;

@RestController
public class VehicleController {
    private final GetAllVehicleData getAllVehicleData;

    public VehicleController(GetAllVehicleData getAllVehicleData) {
        this.getAllVehicleData = getAllVehicleData;
    }

    @GetMapping(value = "/api/vehicle", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Vehicle> getAllDummyData() {
        return getAllVehicleData.getAll();
    }
}
