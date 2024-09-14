package com.example.proyectofinalpoo.Clases;

public class Contabilidad {
    private int id;
    private double dinero;
    private String registros;

    public Contabilidad(int id, double dinero){
        this.id = id;
        this.dinero= dinero;
        this.registros="";
    }

    //Metodos Getters y Setter
    public void setId (int i) {
        id = i;
    }
    public int getId () {
        return id;
    }

    public void setDinero(double d) {
        dinero = d;
    }
    public double getDinero() {
        return dinero;
    }

    public  String getRegistros(){
        return registros;
    }
    public  void setRegistros(String r){
        registros += "\n" + r;
    }
}
