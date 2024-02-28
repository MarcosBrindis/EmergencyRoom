package com.MarcosBrindis.emergencyroom.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Emergency {
    private String tipodeEmergencia;
    private String gravedadDeEmergencia;
    private String sintomas;
    private LocalDate date;
    private LocalTime hour;
    private String detalles;
    private Patient patient;
    private boolean esRoja;
    private TraumaEmergency traumaEmergency;


    public Emergency(String tipodeEmergencia, String gravedadDeEmergencia, boolean esRoja, String sintomas, LocalDate date, LocalTime hour, String detalles, Patient patient) {
        this.tipodeEmergencia = tipodeEmergencia;
        this.gravedadDeEmergencia = gravedadDeEmergencia;
        this.esRoja = esRoja;
        this.sintomas = sintomas;
        this.date = date;
        this.hour = hour;
        this.detalles = detalles;
        this.patient = patient;
    }

    public boolean isEsRoja() {
        return esRoja;
    }

    public void setEsRoja(boolean esRoja) {
        this.esRoja = esRoja;
    }

    public LocalTime getHour() {
        return hour;
    }

    public TraumaEmergency getTraumaEmergency() {
        return traumaEmergency;
    }

    public String getTipodeEmergencia() {
        return tipodeEmergencia;
    }

    public Emergency() {
    }

    public Patient getPatient() {
        return patient;
    }

    public String getSintomas() {
        return sintomas;
    }

    public String getGravedadDeEmergencia() {
        return gravedadDeEmergencia;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setGravedadDeEmergencia(String gravedadDeEmergencia) {
        this.gravedadDeEmergencia = gravedadDeEmergencia;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    @Override
    public String toString() {
        return patient +
                ", date=" + date +
                ", hour=" + hour +
                " tipo de Emergencia= '" + tipodeEmergencia + '\'' +
                ", Gravedad=' " + gravedadDeEmergencia + '\'' +
                //esRoja+
                //", sintomas= '" + sintomas + '\'' +
                //", detalles= '" + detalles + '\'' +

                '}';
    }
}
