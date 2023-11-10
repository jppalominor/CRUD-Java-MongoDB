package com.example.apimongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.apimongo.models.Cargador;

@Repository
public interface CargadorRepository extends MongoRepository<Cargador, Integer>{
    
}
