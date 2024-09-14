package com.example.proyectofinalpoo.Clases;

public class Cargo {
    private  String tipoCargo;
    private int nivel;
    private String obligaciones;
    private String tiempo;

    public Cargo(String  tipoCargo,int nivel){
        this.tipoCargo=tipoCargo;
        this.nivel=nivel;
        this.obligaciones="No hay obligaciones";
        this.tiempo="Indeterminado";
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public int getNivel() {
        return nivel;
    }

    public  void setObligaciones(String obligaciones) {
        this.obligaciones = obligaciones;
    }
    public String getObligaciones() {
        return obligaciones;
    }

    public  void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }
    public String getTiempo() {
        return tiempo;
    }

    public  String getTipoCargo(){
        return tipoCargo;
    }
}
