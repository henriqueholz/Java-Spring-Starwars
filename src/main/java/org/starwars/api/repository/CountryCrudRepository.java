package org.starwars.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.starwars.api.entities.Country;

@RepositoryRestResource
public interface CountryCrudRepository extends CrudRepository<Country, Long> {

    Country findByName(@Param("name") String name);

}
