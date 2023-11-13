package com.example.apimongo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "Horario_Cargadores")
public class Horario_Cargadores {

    @Id
    private int hora;

    private int cargador;

    private Autobus autobus;

    public Horario_Cargadores(int hora, int cargador, Autobus autobus) {
        this.hora = hora;
        this.cargador = cargador;
        this.autobus = autobus;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getCargador() {
        return cargador;
    }

    public void setCargador(int cargador) {
        this.cargador = cargador;
    }

    public Autobus getAutobus() {
        return autobus;
    }

    public void setAutobus(Autobus autobus) {
        this.autobus = autobus;
    }
}

