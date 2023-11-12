package com.example.apimongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.apimongo.models.Autobus;

@Repository
public interface AutobusRepository extends MongoRepository<Autobus, Integer>{
    
    @Query(value = "{ 'placa' : ?0}")
    Autobus findByPlaca(String placa);
}
