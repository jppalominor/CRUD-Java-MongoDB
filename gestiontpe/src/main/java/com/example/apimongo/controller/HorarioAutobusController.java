package com.example.apimongo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apimongo.models.Autobus;
import com.example.apimongo.models.Horario_Autobuses;
import com.example.apimongo.service.HorarioAutobusService;

@RestController
@RequestMapping("/horarioautobuses")
public class HorarioAutobusController {

    @Autowired
    private HorarioAutobusService horarioAutobusService;

    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody Horario_Autobuses horario_Autobus){
        try {
            return new ResponseEntity<Horario_Autobuses>(horarioAutobusService.save(horario_Autobus),HttpStatus.CREATED);   
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getCause().toString(),
                                                        HttpStatus.INTERNAL_SERVER_ERROR);
        }       
    }
    
    @GetMapping
    public ResponseEntity<?> listarTodos(){
        try {
            return new ResponseEntity<List<Horario_Autobuses>>(horarioAutobusService.findAll(),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getCause().toString(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    @GetMapping("/{hora}")
    public ResponseEntity<?> findById(@PathVariable int hora){
        try {
            return new ResponseEntity<Optional<Horario_Autobuses>>(horarioAutobusService.findByHora(hora),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getCause().toString(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

     @PutMapping("/{hora}")
    public ResponseEntity<?> actualizarHorario(@PathVariable int hora, @RequestBody List<Autobus> autobuses){
        try {
            return new ResponseEntity<Horario_Autobuses>(horarioAutobusService.update(hora, autobuses),HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getCause().toString(),HttpStatus.INTERNAL_SERVER_ERROR);        }
    }
    
}
