package org.example.api.repository;

import org.example.api.entities.Starship;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface StarshipRepository extends CrudRepository<Starship, Long> {

    Starship findByName(@Param("name") String name);

}
