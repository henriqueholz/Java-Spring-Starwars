package org.starwars.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.starwars.api.entities.Starship;
import org.starwars.api.useCases.Starship.DecrementUnitByName;
import org.starwars.api.useCases.Starship.GetAll;
import org.starwars.api.useCases.Starship.IncrementUnitByName;
import org.starwars.api.useCases.Starship.SetUnitByName;

import java.util.List;

@RestController
public class StarshipController {
    private final GetAll getAll;
    private final SetUnitByName setUnitByName;
    private final IncrementUnitByName incrementUnitByName;
    private final DecrementUnitByName decrementUnitByName;

    public StarshipController(GetAll getAll, SetUnitByName setUnitByName, IncrementUnitByName incrementUnitByName, DecrementUnitByName decrementUnitByName) {
        this.getAll = getAll;
        this.setUnitByName = setUnitByName;
        this.incrementUnitByName = incrementUnitByName;
        this.decrementUnitByName = decrementUnitByName;
    }

    @GetMapping(value = "/starship")
    public List<Starship> getAll() {
        return getAll.getAll();
    }

    @PutMapping(value = "/starship/{name}/set-unit/{unit}")
    public Starship setUnitByName(@PathVariable String name, @PathVariable int unit) {
        return setUnitByName.update(name, unit);
    }

    @PutMapping(value = "/starship/{name}/increment-unit/{unit}")
    public Starship incrementUnitByName(@PathVariable String name, @PathVariable int unit) {
        return incrementUnitByName.update(name, unit);
    }

    @PutMapping(value = "/starship/{name}/decrement-unit/{unit}")
    public Starship decrementUnitByName(@PathVariable String name, @PathVariable int unit) {
        return decrementUnitByName.update(name, unit);
    }
}
