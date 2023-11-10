package com.example.apimongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apimongo.models.Cargador;
import com.example.apimongo.repository.CargadorRepository;

@Service
public class CargadorService {
    
    @Autowired
    private CargadorRepository cargadorRepo;

    public Cargador save(Cargador cargador){
        return cargadorRepo.save(cargador);
    }

    public List<Cargador> findAll(){
        return cargadorRepo.findAll();
    }

    public Optional<Cargador> findById(int id){
        return cargadorRepo.findById(id);
    }

    public void delete(int id){
        cargadorRepo.deleteById(id);
    }

}
