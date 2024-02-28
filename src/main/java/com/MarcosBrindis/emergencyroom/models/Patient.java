package com.MarcosBrindis.emergencyroom.models;

import java.util.ArrayList;

public class Patient {
    private static int contadorIds = 1000;
    ;
    private int id;
    private String name;
    private int age;
    private String phoneNumber;
    private String gender;
    private String alergia;
    private ArrayList<String> antecedentes;

    public Patient(String name, int age, String phoneNumber, String gender, String alergia, ArrayList<String> antecedentes) {
        this.id = contadorIds++;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.alergia = alergia;
        this.antecedentes = antecedentes;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public int getId() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAlergia() {
        return alergia;
    }

    public ArrayList<String> getAntecedentes() {
        return antecedentes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAlergia(String alergia) {
        this.alergia = alergia;
    }

    public void setAntecedentes(ArrayList<String> antecedentes) {
        this.antecedentes = antecedentes;
    }

    @Override
    public String toString() {
        return
                "ID= '" + id + '\'' +
                        ", Name= '" + name + '\'' +
                        ", edad= " + age + '\'';
        //", genero='" + gender + '\'' +
        //", alergias ='" + alergia + '\'' +
        //", historial medico= " + antecedentes +
        //", no. de telefono ='" + phoneNumber + '\'';
    }
}