package org.starwars.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.starwars.api.entities.Starship;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface StarshipRepository extends MongoRepository<Starship, Long> {

    @Query("{name:'?0'}")
    Starship findByName(String name);

    List<Starship> findAll();

}
