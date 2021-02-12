package com.cloudapps.relational_persistence.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cloudapps.relational_persistence.model.mongo.Provincia;

public interface ProvinciasRepository extends MongoRepository<Provincia, String> {

}
