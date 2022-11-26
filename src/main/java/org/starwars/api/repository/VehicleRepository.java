package org.starwars.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.starwars.api.entities.Starship;
import org.starwars.api.entities.Vehicle;

import java.util.List;

@RepositoryRestResource
public interface VehicleRepository extends MongoRepository<Vehicle, Long> {

    @Query("{name:'?0'}")
    Starship findByName(String name);

    List<Vehicle> findAll();

}
