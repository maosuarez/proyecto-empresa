package com.example.proyectofinalpoo.Repositorios;

import com.example.proyectofinalpoo.Persistence.Persistencia;

public class DataBase {
    protected Persistencia fileManage;

    public DataBase(String fileName) {
        this.fileManage = new Persistencia(fileName);
    }

}
