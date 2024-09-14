package com.example.proyectofinalpoo.Clases;

public class Jefe extends Persona {
    private double salario;
    private String departamento;


    // Constructor
    public Jefe(String nombre, int edad, String genero, double salario, String departamento) {
        super(nombre,edad,genero);
        this.salario = salario;
        this.departamento = departamento;
    }
    public Jefe(String nombre, int edad, String genero){
        super(nombre,edad,genero);
    }

    // Método para obtener el salario del jefe
    public double getSalario() {
        return salario;
    }
    // Método para establecer el salario del jefe
    public void setSalario(double salario) {
        this.salario = salario;
    }

    // Método para obtener el departamento del jefe
    public String getDepartamento() {
        return departamento;
    }
    // Método para establecer el departamento del jefe
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    // Método para incrementar el salario del jefe
    public void incrementarSalario(double incremento) {
        if (incremento > 0) {
            salario += incremento;
        }
    }

    public void dirigir(){
        System.out.println("Estoy dirigiendo a mis empleados");
    }
}
