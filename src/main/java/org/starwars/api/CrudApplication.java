package org.starwars.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
@SpringBootApplication
@EnableMongoRepositories
public class CrudApplication {

    public static void main(final String [] args) {
        SpringApplication.run(CrudApplication.class, args);
    }
}
