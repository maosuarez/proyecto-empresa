package com.example.proyectofinalpoo.Clases;

import java.util.ArrayList;

public class Objeto {

    public Objeto() {
    }

    private ArrayList<Empleado> ListaEmpleados;

    private String string1;

    private String string2;

    //Metodos get and set

    public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
        ListaEmpleados = listaEmpleados;
    }

    public void setString1(String string) {
        this.string1 = string;
    }
    public void setString2(String string) {
        this.string2 = string;
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return ListaEmpleados;
    }

    public String getString1() {
        return string1;
    }
    public String getString2() {
        return string2;
    }

}





