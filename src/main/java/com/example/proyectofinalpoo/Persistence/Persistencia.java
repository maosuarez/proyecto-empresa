package com.example.proyectofinalpoo.Persistence;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Persistencia {
    private String fileName;

    public Persistencia(String fileName) {
        this.fileName = fileName;
    }

    public ArrayList<String> getDataOfFile() {
        ArrayList<String> lines = null;

        try {
            File file = this.getFile();
            if (file.exists()) {
                lines = new ArrayList();
                BufferedReader br = new BufferedReader(new FileReader(file));

                String line;
                while((line = br.readLine()) != null) {
                    lines.add(line);
                }

                br.close();
            }
        } catch (FileNotFoundException var5) {
            FileNotFoundException ex = var5;
            ex.printStackTrace(System.out);
        } catch (IOException var6) {
            IOException e = var6;
            e.printStackTrace(System.out);
        }

        return lines;
    }

    public String getText(){
        String texto = "";
        try{
            File file = this.getFile();
            if (file.exists()){
                BufferedReader br = new BufferedReader(new FileReader(file));

                String line;
                if((line = br.readLine()) != null){
                    texto = line;
                    ArrayList<String> lineas = new ArrayList<>();
                    this.writeLinesToFile(lineas);
                }
                br.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return texto;
    }

    public Boolean insertDataInFile(String line) {
        File file = this.getFile();
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            PrintWriter pw = new PrintWriter(bw);
            pw.println(line);
            pw.flush();
            pw.close();
            return true;
        } catch (IOException var5) {
            IOException e = var5;
            e.printStackTrace(System.out);
            return false;
        }
    }

    public Boolean updateDataInFile(String oldLine, String newLine) {
        ArrayList<String> lines = this.getDataOfFile();
        if (lines != null) {
            for(int i = 0; i < lines.size(); ++i) {
                if (((String)lines.get(i)).equals(oldLine)) {
                    lines.set(i, newLine);
                    this.writeLinesToFile(lines);
                    System.out.println("Linea actualizada exitosamente");
                    return true;
                }
            }

            System.out.println("La linea a actualizar no se encontró en el archivo");
        }

        return false;
    }

    public void deleteDataInFile(String lineToDelete) {
        ArrayList<String> lines = this.getDataOfFile();
        if (lines != null) {
            if (lines.remove(lineToDelete)) {
                this.writeLinesToFile(lines);
                System.out.println("Linea eliminada exitosamente");
            } else {
                System.out.println("La linea a eliminar no se encontró en el archivo");
            }
        }

    }

    private File getFile() {
        return new File("files/" + this.fileName);
    }

    private void writeLinesToFile(ArrayList<String> lines) {
        try {
            PrintWriter output = new PrintWriter(new FileWriter(this.getFile()));
            Iterator var3 = lines.iterator();

            while(var3.hasNext()) {
                String line = (String)var3.next();
                output.println(line);
            }

            output.close();
        } catch (IOException var5) {
            IOException e = var5;
            e.printStackTrace();
        }

    }
}
