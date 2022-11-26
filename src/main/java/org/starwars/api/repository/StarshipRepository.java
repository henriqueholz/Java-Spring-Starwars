package org.starwars.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.starwars.api.entities.Starship;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface StarshipRepository extends MongoRepository<Starship, Long> { }
