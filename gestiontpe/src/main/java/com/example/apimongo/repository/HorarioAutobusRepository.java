package com.example.apimongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.apimongo.models.Horario_Autobuses;


@Repository
public interface HorarioAutobusRepository extends MongoRepository<Horario_Autobuses, Integer>{
    
//    Horario_Autobuses updateHorario_Autobuses(int hora, List<Autobus> autobuses);

}