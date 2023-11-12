package com.example.apimongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apimongo.models.Autobus;
import com.example.apimongo.models.Horario_Autobuses;
import com.example.apimongo.repository.HorarioAutobusRepository;

@Service
public class HorarioAutobusService {
    
    @Autowired
    private HorarioAutobusRepository horarioAutobusRepo;

    public Horario_Autobuses save(Horario_Autobuses horario_Autobus){
        return horarioAutobusRepo.save(horario_Autobus);
    }

    public List<Horario_Autobuses> findAll(){
        return horarioAutobusRepo.findAll();
    }

    public Optional<Horario_Autobuses> findByHora(int hora){
        return horarioAutobusRepo.findById(hora);
    }

    public Horario_Autobuses update(int hora, List<Autobus> autobuses){
        horarioAutobusRepo.deleteById(hora);

        Horario_Autobuses nuevoHorario = new Horario_Autobuses(hora, autobuses);
        return horarioAutobusRepo.save(nuevoHorario);
       
    }
    public void deleteAutobus(int hora, String placa){
       //TODO: implementar eliminar programacion para un autobus por placa 
    }

}
