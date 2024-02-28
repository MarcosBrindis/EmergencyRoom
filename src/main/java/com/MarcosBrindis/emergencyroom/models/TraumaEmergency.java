package com.MarcosBrindis.emergencyroom.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class TraumaEmergency extends Emergency {
    private String causa;
    private String ubicacionLesion;
    private String gravedadLesion;

    public TraumaEmergency(String tipodeEmergencia, String gravedadDeEmergencia, boolean esRoja, String sintomas, LocalDate date, LocalTime hour, String detalles, Patient patient, String causa, String ubicacionLesion, String gravedadLesion) {
        super(tipodeEmergencia, gravedadDeEmergencia, esRoja, sintomas, date, hour, detalles, patient);
        this.causa = causa;
        this.ubicacionLesion = ubicacionLesion;
        this.gravedadLesion = gravedadLesion;
    }

    public TraumaEmergency() {
    }

    public String getCausa() {
        return causa;
    }

    public String getUbicacionLesion() {
        return ubicacionLesion;
    }

    public String getGravedadLesion() {
        return gravedadLesion;
    }

    @Override
    public String toString() {
        return
                super.toString() +
                        " Causa de la herida ='" + causa + '\'';
        //", Localizacion de la herida='" + ubicacionLesion + '\'' +
        //", severidad de lesion='" + gravedadLesion + '\'';
    }
}