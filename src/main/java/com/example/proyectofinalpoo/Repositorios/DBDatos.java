package com.example.proyectofinalpoo.Repositorios;

import com.example.proyectofinalpoo.Clases.Usuarios;
import com.example.proyectofinalpoo.Interfaces.IBaseDatos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class DBDatos extends DataBase implements IBaseDatos {

    public DBDatos() {
        super("DatosInmediatos.txt");
    }

    @Override
    public ArrayList<Usuarios> getListData() {
        ArrayList<Usuarios> usuarios = new ArrayList();
        ArrayList<String> lines = this.fileManage.getDataOfFile();
        if (lines != null) {
            Iterator var3 = lines.iterator();
            while(var3.hasNext()) {
                String line = (String)var3.next();
                StringTokenizer tokens = new StringTokenizer(line, "|");
                String nombre = tokens.nextToken();
                String contra = tokens.nextToken();
                int edad = Integer.parseInt(tokens.nextToken());
                String genero = tokens.nextToken();
                String direccion = tokens.nextToken();
                String puesto = tokens.nextToken();
                String telefono = tokens.nextToken();
                float salario = Float.parseFloat(tokens.nextToken());
                usuarios.add(new Usuarios(nombre,contra, puesto, edad, genero, salario,telefono, direccion));
                this.deleteData(line);
            }
        }

        return usuarios;
    }

    public String getFila(){
        String texto;
        texto = this.fileManage.getText();
        return texto;
    }

    public Boolean updateData(String oldBook, String newBook) {
        return this.fileManage.updateDataInFile(oldBook, newBook);
    }

    public Boolean addData(Usuarios usuarios) {
        int var10000 = usuarios.getEdad();
        String lineBook = "" + usuarios.getNombre()
                + "|" + usuarios.getContra()
                + "|" +  var10000
                + "|" + usuarios.getGenero()
                + "|" + usuarios.getDireccion()
                + "|" + usuarios.getPuesto()
                + "|" + usuarios.getTelefono()
                + "|" + usuarios.getSalario();
        return this.fileManage.insertDataInFile(lineBook);
    }

    public Boolean addData(String linea) {
        this.fileManage.deleteDataInFile(linea);

        return this.fileManage.insertDataInFile(linea);
    }

    public void deleteData(String linea) {
        this.fileManage.deleteDataInFile(linea);
    }

}
