package org.starwars.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.starwars.api.entities.Starship;
import org.starwars.api.entities.UnitCountResponse;
import org.starwars.api.useCases.Starship.DecrementUnitByName;
import org.starwars.api.useCases.Starship.GetUnitByName;
import org.starwars.api.useCases.Starship.IncrementUnitByName;
import org.starwars.api.useCases.Starship.SetUnitByName;


import java.util.Optional;

@RestController
public class StarshipController {
    private final GetUnitByName getUnitByName;
    private final SetUnitByName setUnitByName;
    private final IncrementUnitByName incrementUnitByName;
    private final DecrementUnitByName decrementUnitByName;

    public StarshipController(GetUnitByName getUnitByName, SetUnitByName setUnitByName, IncrementUnitByName incrementUnitByName, DecrementUnitByName decrementUnitByName) {
        this.getUnitByName = getUnitByName;
        this.setUnitByName = setUnitByName;
        this.incrementUnitByName = incrementUnitByName;
        this.decrementUnitByName = decrementUnitByName;
    }

    @GetMapping(value = "/starship/{name}")
    public ResponseEntity<UnitCountResponse> getByName(@PathVariable String name) {
        return ToResponseEntity(Optional.ofNullable(getUnitByName.get(name)));
    }

    @PutMapping(value = "/starship/{name}/set-unit/{unit}")
    public ResponseEntity<UnitCountResponse> setUnitByName(@PathVariable String name, @PathVariable int unit) {
        return ToResponseEntity(Optional.ofNullable(setUnitByName.update(name, unit)));
    }

    @PutMapping(value = "/starship/{name}/increment-unit/{unit}")
    public ResponseEntity<UnitCountResponse> incrementUnitByName(@PathVariable String name, @PathVariable int unit) {
        return ToResponseEntity(Optional.ofNullable(incrementUnitByName.update(name, unit)));
    }

    @PutMapping(value = "/starship/{name}/decrement-unit/{unit}")
    public ResponseEntity<UnitCountResponse> decrementUnitByName(@PathVariable String name, @PathVariable int unit) {
        return ToResponseEntity(Optional.ofNullable(decrementUnitByName.update(name, unit)));
    }

    public ResponseEntity<UnitCountResponse> ToResponseEntity(Optional<Starship> starship) {
        if (starship.isPresent()) {
            UnitCountResponse unitCountResponse = new UnitCountResponse(starship.get().getId(), starship.get().getName(), starship.get().getCount());
            return new ResponseEntity<>(unitCountResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
