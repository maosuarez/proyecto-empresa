package com.example.proyectofinalpoo.Clases;

public class Nomina {
    private int id;
    private String fechaPago;

    public  Nomina() {}
    public  Nomina(int id,String fecha){ this.id=id;this.fechaPago = fecha;}

    //Metodos Getter y Setter
    public void setId(int i){
        this.id=i;
    }
    public int getId (){
        return this.id;
    }
    public void setFecha(String f){
        this.fechaPago=f;
    }
    public String getFecha(){
        return this.fechaPago;
    }

    public String AsignarNomina(String nuevaNomina){
        System.out.println("Se le asigno la nomina: "+nuevaNomina+" al trabajador");
        return  nuevaNomina;
    }

    public void RetenerSalario(){
        System.out.println("Salario retenido");
    }
    public void EnviarSaldo(){
        System.out.println("El salario ha sido pagado con exito");
    }
}
