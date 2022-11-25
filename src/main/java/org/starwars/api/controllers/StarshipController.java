package org.starwars.api.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.starwars.api.entities.Starship;
import org.starwars.api.useCases.GetAllStarshipData;

import java.util.List;

@RestController
public class StarshipController {
    private final GetAllStarshipData getAllStarshipData;

    public StarshipController(GetAllStarshipData getAllStarshipData) {
        this.getAllStarshipData = getAllStarshipData;
    }

    @GetMapping(value = "/api/starship", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Starship> getAllDummyData() {
        return getAllStarshipData.getAll();
    }
}
