package com.example.proyectofinalpoo.Repositorios;

import com.example.proyectofinalpoo.Clases.Usuarios;
import com.example.proyectofinalpoo.Interfaces.IBaseDatos;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class DBUsuarios extends DataBase implements IBaseDatos {

    public DBUsuarios() {
        super("Usuarios.txt");
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
            }
        }

        return usuarios;
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

    public Boolean updateData(Usuarios oldBook, Usuarios newBook) {
        int var10000 = oldBook.getEdad();
        String lineOldBook = "" + oldBook.getNombre()
                + "|" + oldBook.getContra()
                + "|" +  var10000
                + "|" + oldBook.getGenero()
                + "|" + oldBook.getDireccion()
                + "|" + oldBook.getPuesto()
                + "|" + oldBook.getTelefono()
                + "|" + oldBook.getSalario();
        var10000 = newBook.getEdad();
        String lineNewBook = "" + newBook.getNombre()
                + "|" + newBook.getContra()
                + "|" +  var10000
                + "|" + newBook.getGenero()
                + "|" + newBook.getDireccion()
                + "|" + newBook.getPuesto()
                + "|" + newBook.getTelefono()
                + "|" + newBook.getSalario();
        return this.fileManage.updateDataInFile(lineOldBook, lineNewBook);
    }

    public void deleteData(Usuarios book) {
        int var10000 = book.getEdad();
        String lineBook = "" + book.getNombre()
                + "|" + book.getContra()
                + "|" +  var10000
                + "|" + book.getGenero()
                + "|" + book.getDireccion()
                + "|" + book.getPuesto()
                + "|" + book.getTelefono()
                + "|" + book.getSalario();
        this.fileManage.deleteDataInFile(lineBook);
    }
}
