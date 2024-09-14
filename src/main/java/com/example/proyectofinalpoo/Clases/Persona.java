package com.example.proyectofinalpoo.Clases;

public class Persona {
    //Atributos de la clase persona.
    private String nombre;
    private int edad;
    private String genero;

    //Constructor
    public Persona(String nombre, int edad, String genero){
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
    }

    //Metodos getter y setter
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre=nombre;
    }

    public int getEdad(){
        return this.edad;
    }

    public void setEdad(int edad){
        if (edad >0 ){
            this.edad = edad;
        }else{
            this.edad = 1;
            System.out.println("La edad debe ser mayor a cero");
        }

    }

    public String getGenero() {
        return this.genero;
    }

    public  void setGenero(String genero) {
        if (genero.equals("hombre") || genero.equals("mujer")){
            this.genero = genero;
        }else{
            this.genero = "otro";
        }
    }

}
