package com.example.apimongo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apimongo.models.Autobus;
import com.example.apimongo.service.AutobusService;

@RestController
@RequestMapping("/autobuses")
public class AutobusController {

    @Autowired
    private AutobusService autobusService;

    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody Autobus autobus){
        try {
            return new ResponseEntity<Autobus>(autobusService.save(autobus),HttpStatus.CREATED);   
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getCause().toString(),
                                                        HttpStatus.INTERNAL_SERVER_ERROR);
        }       
    }

    @GetMapping
    public ResponseEntity<?> listarTodos(){
        try {
            return new ResponseEntity<List<Autobus>>(autobusService.findAll(),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getCause().toString(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        try {
            return new ResponseEntity<Optional<Autobus>>(autobusService.findById(id),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getCause().toString(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id){
        try {
            autobusService.delete(id);
            return new ResponseEntity<String>("Elemento eliminado",HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getCause().toString(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
