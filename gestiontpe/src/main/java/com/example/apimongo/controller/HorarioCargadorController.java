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
import com.example.apimongo.models.Horario_Cargadores;
import com.example.apimongo.service.HorarioCargadorService;

@RestController
@RequestMapping("/horariocargadores")
public class HorarioCargadorController {

    @Autowired
    private HorarioCargadorService horarioCargadorService;

    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody Horario_Cargadores horario_Cargador){
        try {
            return new ResponseEntity<Horario_Cargadores>(horarioCargadorService.save(horario_Cargador),HttpStatus.CREATED);   
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getCause().toString(),
                                                        HttpStatus.INTERNAL_SERVER_ERROR);
        }       
    }

    @GetMapping
    public ResponseEntity<?> listarTodos(){
        try {
            return new ResponseEntity<List<Horario_Cargadores>>(horarioCargadorService.findAll(),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getCause().toString(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    @GetMapping("/{hora}")
    public ResponseEntity<?> findById(@PathVariable int hora){
        try {
            return new ResponseEntity<Optional<Horario_Cargadores>>(horarioCargadorService.findByHora(hora),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getCause().toString(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("/{hora}/{cargador}")
    public ResponseEntity<?> actualizarHorario(@PathVariable int hora, @PathVariable int cargador, @RequestBody Autobus autobuses){
        try {
            return new ResponseEntity<Horario_Cargadores>(horarioCargadorService.update(hora, cargador, autobuses),HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getCause().toString(),HttpStatus.INTERNAL_SERVER_ERROR);        }
    }
    
}

