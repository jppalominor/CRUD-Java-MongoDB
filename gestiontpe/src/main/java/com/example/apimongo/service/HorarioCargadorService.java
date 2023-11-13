package com.example.apimongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apimongo.models.Autobus;
import com.example.apimongo.models.Horario_Cargadores;
import com.example.apimongo.repository.HorarioCargadorRepository;

@Service
public class HorarioCargadorService {

    @Autowired
    private HorarioCargadorRepository horarioCargadorRepo;

    public Horario_Cargadores save(Horario_Cargadores horario_Cargador){
        return horarioCargadorRepo.save(horario_Cargador);
    }

    public List<Horario_Cargadores> findAll(){
        return horarioCargadorRepo.findAll();
    }

    public Optional<Horario_Cargadores> findByHora(int hora){
        return horarioCargadorRepo.findById(hora);
    }

    public Horario_Cargadores update(int hora, int cargador, Autobus autobus){
        horarioCargadorRepo.deleteById(hora);

        Horario_Cargadores nuevoHorario = new Horario_Cargadores(hora, cargador, autobus);
        return horarioCargadorRepo.save(nuevoHorario);
       
    }


    
}
