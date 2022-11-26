package org.starwars.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class CrudApplication {

    public static void main(final String [] args) {
        SpringApplication.run(CrudApplication.class, args);
    }
}
