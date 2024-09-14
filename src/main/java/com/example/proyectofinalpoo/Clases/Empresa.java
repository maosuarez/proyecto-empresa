package com.example.proyectofinalpoo.Clases;

public class Empresa {
    private String nombre;
    private int rut;

    // Constructor
    public Empresa(String nombre, int rut) {
        this.nombre = nombre;
        this.rut = rut;
    }

    public Empresa(String miEmpresa, String number) {
    }

    // Métodos Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }
}
