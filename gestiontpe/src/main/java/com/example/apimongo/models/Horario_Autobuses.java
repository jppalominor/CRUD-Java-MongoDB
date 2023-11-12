package com.example.apimongo.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "Horario_Autobuses")
public class Horario_Autobuses {

    @Id
    private int hora;

    private List<Autobus> autobuses;

    public Horario_Autobuses(int hora, List<Autobus> autobuses) {
        this.hora = hora;
        this.autobuses = autobuses;
    }

    public List<Autobus> getAutobus() {
        return autobuses;
    }

    public void setAutobus(List<Autobus> autobuses) {
        this.autobuses = autobuses;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }
    
    
}
