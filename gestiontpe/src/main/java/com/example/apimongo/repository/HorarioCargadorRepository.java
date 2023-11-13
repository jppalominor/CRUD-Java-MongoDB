package com.example.apimongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.apimongo.models.Horario_Cargadores;

@Repository
public interface HorarioCargadorRepository extends MongoRepository<Horario_Cargadores,Integer>{
    
}
