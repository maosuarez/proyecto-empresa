package com.example.proyectofinalpoo.Clases;

public class Empleado extends Persona {

    private String direccion;
    private String puesto;
    private String telefono;
    private Empresa empresa;
    private Salario salario;
    private Cargo cargo;

    // Constructor
    public Empleado(String nombre, int edad, String genero, String puesto, String direccion, String telefono) {

        super(nombre,edad,genero);
        this.direccion = direccion;
        this.puesto = puesto;
        this.telefono = telefono;

    }
    public Empleado(String nombre, int edad, String genero, String puesto){
        super(nombre, edad, genero);
        this.puesto = puesto;
    }

    public Empleado(String nombre, int edad, String genero){
        super(nombre,edad,genero);
    }

    // Métodos Getters y Setters

    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPuesto() {
        return puesto;
    }
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Empresa getEmpresa() {
        return empresa;
    }
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Salario getSalario() {
        return salario;
    }
    public void setSalario(Salario salario) {
        this.salario = salario;
    }

    public Cargo getCargo(){
        return cargo;
    }
    public void setCargo(Cargo c){
        cargo=c;
    }

}
