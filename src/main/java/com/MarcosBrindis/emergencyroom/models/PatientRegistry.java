package com.MarcosBrindis.emergencyroom.models;

import java.util.ArrayList;

public class PatientRegistry {
    private ArrayList<Emergency> formulario;

    public PatientRegistry() {
        this.formulario = new ArrayList<>();
    }

    public void addEmergency(Emergency emergency) {
        formulario.add(emergency);
    }

    public ArrayList<Emergency> getFormulario() {
        return formulario;
    }

    public void setFormulario(ArrayList<Emergency> formulario) {
        this.formulario = formulario;
    }

    @Override
    public String toString() {
        return "PatientRegistry{" +
                "formulario=" + formulario +
                '}';
    }
}
