package com.example.proyectofinalpoo.Clases;

public class Salario {
    private double monto;
    private String tipo; // Por hora, mensual, etc.

    // Constructor
    public Salario(double monto, String tipo) {
        this.monto = monto;
        this.tipo = tipo;
    }
    public Salario(double monto){
        this.monto = monto;
        this.tipo = "Mensual";
    }

    // Métodos Getters y Setters
    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
