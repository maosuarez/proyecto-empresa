package com.example.proyectofinalpoo.Clases;

public class Usuarios {

    //Atributos

    private Salario salario;

    private Empleado empleado;

    private String direccion;
    private String telefono;
    private String contra;

    //Metodos

    public Usuarios(){
    }

    public Usuarios(String nombre, String contra, String puesto, Integer edad, String genero,  Float salario, String telefono, String direccion){
        this.empleado = new Empleado(nombre, edad, genero, puesto);
        this.salario = new Salario((double)salario);
        this.contra = contra;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getGenero(){
        return this.empleado.getGenero();
    }
    public void setGenero(String genero){
        empleado.setGenero(genero);
    }

    public Float getSalario() {
        return (float)this.salario.getMonto();
    }
    public void setSalario(Float salario) {
        this.salario.setMonto((double)salario);
    }

    public int getEdad() {
        return empleado.getEdad();
    }
    public void setEdad(int edad) {
        empleado.setEdad(edad);
    }

    public String getNombre() {
        return empleado.getNombre();
    }
    public void setNombre(String nombre) {
        empleado.setNombre(nombre);
    }

    public String getPuesto() {
        return empleado.getPuesto();
    }
    public void setPuesto(String puesto) {
        empleado.setPuesto(puesto);
    }

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContra() {
        return contra;
    }
    public void setContra(String contra) {
        this.contra = contra;
    }
}
