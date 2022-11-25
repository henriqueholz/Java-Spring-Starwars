package org.starwars.api.repository;

import org.starwars.api.entities.Starship;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface StarshipRepository extends CrudRepository<Starship, Long> {

    Starship findByName(@Param("name") String name);

    List<Starship> findAll();

}
