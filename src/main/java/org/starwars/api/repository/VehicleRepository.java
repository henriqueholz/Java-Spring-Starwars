package org.starwars.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.starwars.api.entities.Vehicle;


@RepositoryRestResource
public interface VehicleRepository extends MongoRepository<Vehicle, Long> { }
