package org.starwars.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.starwars.api.entities.Starship;
import org.starwars.api.useCases.Starship.DecrementUnitByName;
import org.starwars.api.useCases.Starship.GetUnitByName;
import org.starwars.api.useCases.Starship.IncrementUnitByName;
import org.starwars.api.useCases.Starship.SetUnitByName;

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
    public Starship getByName(@PathVariable String name) {
        return getUnitByName.get(name);
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
