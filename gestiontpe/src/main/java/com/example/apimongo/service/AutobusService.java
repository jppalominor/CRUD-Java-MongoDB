package com.example.apimongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apimongo.models.Autobus;
import com.example.apimongo.repository.AutobusRepository;

@Service
public class AutobusService {

    @Autowired
    private AutobusRepository autobusRepository;
    
    public Autobus save(Autobus autobus){
       return autobusRepository.save(autobus);
    }

    public List<Autobus> findAll(){
        return autobusRepository.findAll();
    }

    public Optional<Autobus> findById(int id){
        return autobusRepository.findById(id);
    }

    public void delete(int id){
        autobusRepository.deleteById(id);
    }


    
}
